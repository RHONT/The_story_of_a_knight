package com.rhontproject.acts;

import static com.rhontproject.fabrica.UnitFabric.*;
import static com.rhontproject.stateMethods.Utility.fight;
import static com.rhontproject.stateMethods.Utility.read_file;

public class Act_5 extends Act {
    @Override
    public void run() {
        read_file("[2].txt");
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fight(knight, createBear());
    }
}