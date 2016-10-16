package producer.service;

public interface ProducerService {

	public void sendTextMessageToQueue(String queueName, String text);
}
