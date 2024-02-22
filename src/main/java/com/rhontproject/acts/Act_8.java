package com.rhontproject.acts;

import static com.rhontproject.fabrica.UnitFabric.createKnight;
import static com.rhontproject.fabrica.UnitFabric.createKnightDark;
import static com.rhontproject.stateMethods.Utility.fight_test_vs_shadow;
import static com.rhontproject.stateMethods.Utility.read_file;

public class Act_8 extends Act {
    @Override
    public void run() {
        read_file("[5].txt");
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fight_test_vs_shadow(knight, createKnight(), createKnight(), createKnight());
    }
}
