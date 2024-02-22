package com.rhontproject.acts;

import static com.rhontproject.fabrica.UnitFabric.createOutLowBig;
import static com.rhontproject.fabrica.UnitFabric.createOutLowSmall;
import static com.rhontproject.stateMethods.Utility.fight;
import static com.rhontproject.stateMethods.Utility.read_file;

public class Act_4 extends Act {
    @Override
    public void run() {
        read_file("out_law_story.txt");
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fight(knight, createOutLowSmall(), createOutLowBig());
    }
}
