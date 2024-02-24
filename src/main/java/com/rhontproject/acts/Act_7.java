package com.rhontproject.acts;

import static com.rhontproject.fabrica.ActsFabric.halt;
import static com.rhontproject.fabrica.ActsFabric.levelUp;
import static com.rhontproject.fabrica.UnitFabric.createKnightDark;
import static com.rhontproject.stateMethods.Utility.*;

public class Act_7 extends Act {
    @Override
    public void run() {
        printFromFile("[3].txt");
        scanner.nextLine();
        printFromFile("[4].txt");
        scanner.nextLine();
        fight(knight,createKnightDark());
        System.out.println("Нажмиет Enter для продолжения");

        halt();
        levelUp();

        printFromFile("[5].txt");
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fight(knight,createKnightDark(), createKnightDark());
    }
}
