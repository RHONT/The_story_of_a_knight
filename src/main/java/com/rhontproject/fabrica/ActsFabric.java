package com.rhontproject.fabrica;

import com.rhontproject.acts.Act_1_Prologue;
import com.rhontproject.acts.Act_2;
import com.rhontproject.acts.Halt;
import com.rhontproject.acts.LevelUp;


public final class ActsFabric {
    private final static Halt halt = new Halt();
    private final static LevelUp levelUp = new LevelUp();

    private ActsFabric() {
    }

    public static void act_1() {
        new Act_1_Prologue().run();
    }

    public static void act_2() {
        new Act_2().run();
    }

    public static void halt() {
        halt.run();
    }

    public static void levelUp() {
        levelUp.run();
    }
}
