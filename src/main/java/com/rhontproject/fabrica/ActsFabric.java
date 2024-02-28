package com.rhontproject.fabrica;

import com.rhontproject.acts.*;
import com.rhontproject.acts.actsaction.Halt;
import com.rhontproject.acts.actsaction.LevelUp;
import com.rhontproject.acts.actsaction.Market;


public final class ActsFabric {
    private final static Halt halt = new Halt();
    private final static LevelUp levelUp = new LevelUp();
    private final static Market market = new Market();

    private ActsFabric() {
    }

    public static void act_1() {
        new Act_1().run();
    }

    public static void act_2() {
        new Act_2().run();
    }

    public static void act_3() {
        new Act_3().run();
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
