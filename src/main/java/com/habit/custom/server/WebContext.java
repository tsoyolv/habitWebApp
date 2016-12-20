package com.habit.custom.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * OLTS on 20.12.2016.
 */
public class WebContext {

    private static ApplicationContext appContextFromXml =
            new ClassPathXmlApplicationContext("/custom/webAppContext.xml");

    public static <T> T getBean(String beanName) {
        return (T) appContextFromXml.getBean(beanName);
    }
}
