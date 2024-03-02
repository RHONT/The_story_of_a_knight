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
        Act act = (Act) context.getBean("act_1");
        act.run();
    }

    public static void act_2() {
        Act act = (Act) context.getBean("act_2");
        act.run();
    }

    public static void act_3() {
        Act act = (Act) context.getBean("act_3");
        act.run();
    }

    public static void act_4() {
        Act act4 = (Act) context.getBean("act_4");
        act4.run();
    }
//
//    public static void act_5() {
//        new Act_5().run();
//    }
//    public static void act_6() {
//        new Act_6().run();
//    }
//
//    public static void act_7() {
//        new Act_7().run();
//    }
//
//    public static void act_8() {
//        new Act_8().run();
//    }

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