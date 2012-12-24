package com.prabhat.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextProvider {
	
	private static ApplicationContext context;
	public static ApplicationContext gtApplicationContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("/spring-hibernat.xml");
		}
		return context;
	}

}
