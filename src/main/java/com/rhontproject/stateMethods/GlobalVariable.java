package com.rhontproject.stateMethods;

import com.rhontproject.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GlobalVariable {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static MessageService messageService= (MessageService) context.getBean("messageService");
}
