package com.rhontproject.acts;

import static com.rhontproject.fabrica.UnitFabric.createZombie;
import static com.rhontproject.stateMethods.Utility.fight;
import static com.rhontproject.stateMethods.Utility.printFromFile;

public class Act_2 extends Act {

    @Override
    public void run() {
        printFromFile("[1-1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fight(knight, createZombie(), createZombie());
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
