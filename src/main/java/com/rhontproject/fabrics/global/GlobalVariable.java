package com.rhontproject.fabrics.global;

import com.rhontproject.fabrics.units.Knight;
import com.rhontproject.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Глобальные переменные для удобства вызова из любой точки программы (bad practices)
 * messageService - сервис для работы с сообщениями, для последующего вывода в консоль
 * knight - герой игры
 */
public final class GlobalVariable {
    private GlobalVariable() {
    }
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static final MessageService messageService= (MessageService) context.getBean("messageService");
    public static final Knight knight=(Knight) context.getBean("Knight");
}
