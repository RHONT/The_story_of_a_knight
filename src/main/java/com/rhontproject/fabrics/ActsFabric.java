package com.rhontproject.fabrics;

import com.rhontproject.acts.*;
import com.rhontproject.acts.actsaction.Halt;
import com.rhontproject.acts.actsaction.LevelUp;
import com.rhontproject.acts.actsaction.Market;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public final class ActsFabric {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private final static Halt halt = new Halt();
    private final static LevelUp levelUp = new LevelUp();
    private final static Market market = new Market();

    private ActsFabric() {
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

//    public static void act_4() {
//        new Act_4().run();
//    }
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
        halt.run();
    }

    public static void levelUp() {
        levelUp.run();
    }

    public static void market() {
        market.run();
    }
}
