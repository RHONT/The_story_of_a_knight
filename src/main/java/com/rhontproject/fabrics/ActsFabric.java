package com.rhontproject.fabrics;

import com.rhontproject.acts.*;
import com.rhontproject.service.EventKnightService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Фабрика для удобства, чтобы в клиентском коде вызывать сразу нужный акт.
 */
@Component
public final class ActsFabric {

    private ActsFabric() {
    }
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    private static final EventKnightService eventKnightService=context.getBean("eventKnightService",EventKnightService.class);

    public static void act1() {
        Act act = (Act) context.getBean("act1");
        act.run();
    }

    public static void act2() {
        Act act = (Act) context.getBean("act2");
        act.run();
    }

    public static void act3() {
        Act act = (Act) context.getBean("act3");
        act.run();
    }

    public static void act4() {
        Act act = (Act) context.getBean("act4");
        act.run();
    }

    public static void act5() {
        Act act = (Act) context.getBean("act5");
        act.run();
    }

    public static void act6() {
        Act act = (Act) context.getBean("act6");
        act.run();
    }

    public static void act7() {
        Act act = (Act) context.getBean("act7");
        act.run();
    }

    public static void act8() {
        Act act = (Act) context.getBean("act8");
        act.run();
    }

    public static void halt() {
        eventKnightService.halt();
    }

    public static void levelUp() {
        eventKnightService.levelUp();
    }

    public static void market() {
        eventKnightService.market();
    }
}
