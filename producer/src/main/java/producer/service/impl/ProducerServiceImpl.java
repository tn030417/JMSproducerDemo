package producer.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import producer.service.ProducerService;

public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private JmsTemplate jmsTemplate = null;
	
	public void sendTextMessageToQueue(String queueName, final String text){		
		MessageCreator message = createMessage(text);		
		jmsTemplate.send(queueName, message);
	}
	
	private MessageCreator createMessage(final String text){		
		MessageCreator result = new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(text);
				return textMessage;
			}
		};
		
		return result;
	}
}
