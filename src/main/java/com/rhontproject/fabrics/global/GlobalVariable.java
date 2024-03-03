package com.rhontproject.fabrics.global;

import com.rhontproject.fabrics.units.Knight;
import com.rhontproject.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public final class GlobalVariable {
    private GlobalVariable() {
    }
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static final MessageService messageService= (MessageService) context.getBean("messageService");
    public static final Knight knight=(Knight) context.getBean("Knight");
}
