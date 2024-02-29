package com.rhontproject.fabrics;

import com.rhontproject.service.EventKnightService;
import com.rhontproject.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GlobalVariable {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static MessageService messageService= (MessageService) context.getBean("messageService");
    public static EventKnightService eventKnightService= (EventKnightService) context.getBean("eventKnightService");
}
