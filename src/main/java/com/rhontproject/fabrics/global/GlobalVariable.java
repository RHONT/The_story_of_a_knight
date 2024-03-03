package com.rhontproject.fabrics.global;

import com.rhontproject.fabrics.units.Knight;
import com.rhontproject.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GlobalVariable {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static MessageService messageService= (MessageService) context.getBean("messageService");
    public static Knight knight=(Knight) context.getBean("Knight");
}
