package com.iba.utils.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebListener
public class IListener implements ServletContextListener{

	private static final Logger logger = LoggerFactory.getLogger(IListener.class);

	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
		logger.info("iListener init ...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		logger.info("iListener destroy ...");
	}
}
