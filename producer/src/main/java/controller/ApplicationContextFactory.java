package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextFactory implements ApplicationContextAware {

	private static Log log = LogFactory.getLog(ApplicationContextFactory.class);

	private static ApplicationContext appContext = null;

	public static ApplicationContext getContext(String appContextFileName) {
		if (appContext == null) {
			try {
				AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(appContextFileName);
				ctx.registerShutdownHook();
				if (appContext == null) {
					appContext = ctx;
				}
			} catch (Exception e) {
				log.error("Greska pri instanciranju Spring applicationContext-a", e);
			}
			log.info("Application context: " + appContext);
		}
		return appContext;
	}

	public static Object getBeanFromContext(String appContextFileName, String beanName) {
		ApplicationContext ctx = ApplicationContextFactory.getContext(appContextFileName);
		return ctx.getBean(beanName);
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (appContext == null) {
			appContext = applicationContext;
		}
	}

}
