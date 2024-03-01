package com.rhontproject.fabrics.global;

import com.rhontproject.fabrics.units.Knight;
import com.rhontproject.service.EventKnightService;
import com.rhontproject.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class GlobalVariable {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static MessageService messageService= (MessageService) context.getBean("messageService");
    public static Knight knight=(Knight) context.getBean("Knight");
//    public static EventKnightService eventKnightService= (EventKnightService) context.getBean("eventKnightService");
}
