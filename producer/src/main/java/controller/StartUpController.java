package controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUpController implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Test");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Test");
	}

}
