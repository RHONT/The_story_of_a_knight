package com.rhontproject.fabrics;

import com.rhontproject.acts.*;
import com.rhontproject.service.EventKnightService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public final class ActsFabric {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

private static EventKnightService eventKnightService;

    public ActsFabric(EventKnightService eventKnightService) {
        ActsFabric.eventKnightService = eventKnightService;
    }

    public static void act_1() {
        Act act = (Act) context.getBean("act1");
        act.run();
    }

    public static void act_2() {
        Act act = (Act) context.getBean("act2");
        act.run();
    }

    public static void act_3() {
        Act act = (Act) context.getBean("act3");
        act.run();
    }

    public static void act_4() {
        Act act = (Act) context.getBean("act4");
        act.run();
    }

    public static void act_5() {
        Act act = (Act) context.getBean("act5");
        act.run();
    }
    public static void act_6() {
        Act act = (Act) context.getBean("act6");
        act.run();
    }

    public static void act_7() {
        Act act = (Act) context.getBean("act7");
        act.run();
    }

    public static void act_8() {
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
