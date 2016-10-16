package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import producer.thread.ProducerThread;

public class ProducerController {
	
	private List<Thread> producerList = new ArrayList<Thread>();
	private int numberOfCreatedProducers = 0;
	
	@Value("${activemq-queueName}")
	private String queueName;

	public synchronized void addProducer(){
		ProducerThread newProducer = new ProducerThread("Producer-" + getNumberOfCreatedProducers(), queueName);
		Thread t = new Thread(newProducer);
		incNumberOfCreatedProducers();
		producerList.add(t);
		t.start();
	}
	
	public synchronized int getNumberOfCreatedProducers(){
		return numberOfCreatedProducers;
	}
	
	public synchronized void incNumberOfCreatedProducers(){
		numberOfCreatedProducers++;
	}
	
	public synchronized void stopAllProducers(){
		for (int i=0; i<producerList.size();i++){
			stopProducer(i);
		}
	}

	private synchronized void stopProducer(int producerNumber){
		Thread producer = producerList.get(producerNumber);
		producer.interrupt();
	}
}
