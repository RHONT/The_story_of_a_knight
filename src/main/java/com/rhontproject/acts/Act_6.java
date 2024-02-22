package com.rhontproject.acts;

import java.util.Arrays;

import static com.rhontproject.fabrica.UnitFabric.createBear;
import static com.rhontproject.fabrica.UnitFabric.createOutLowBridge;
import static com.rhontproject.stateMethods.Utility.*;

public class Act_6 extends Act {
    @Override
    public void run() {
        read_file("[2-1].txt");
        bridge(knight, stateGame, createOutLowBridge(), createOutLowBridge(), createOutLowBridge(), createOutLowBridge());
        System.out.println(Arrays.toString(knight.param_inventory));
    }
}
