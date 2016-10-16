package producer.thread;

import org.apache.log4j.Logger;
import org.springframework.jms.JmsException;

import producer.service.ProducerService;
import utilities.Const;
import utilities.DateUtilities;
import controller.ApplicationContextFactory;

public class ProducerThread implements Runnable{

	private static final Logger logger = Logger.getLogger(ProducerThread.class);
	
	private ProducerService producerService;
	private String threadName;
	private String queueName;
	
	public ProducerThread(String threadName, String queueName){
		this.threadName = threadName;
		this.queueName = queueName;
		initProducerService();
	}	
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			try {
				String message = createMessage();
				producerService.sendTextMessageToQueue(queueName, message);
				logger.debug(threadName + " - send message - " + message);
				Thread.sleep(1000);
			} catch (InterruptedException e) {	
				logger.debug(threadName + " - Interupted");
				Thread.currentThread().interrupt();
			} catch (JmsException e) {	
					logger.info(threadName + " - JmsException - " + e);
			}			
		}
	}
	
	private String createMessage(){
		String result = threadName + " : " + DateUtilities.currentTimeString();		
		return result;
	}
	
	private void initProducerService(){
		producerService = (ProducerService) ApplicationContextFactory.getBeanFromContext(Const.APP_CONTEXT_FILENAME, Const.PRODUCERSERVICE_BEANNAME);
	}
}
