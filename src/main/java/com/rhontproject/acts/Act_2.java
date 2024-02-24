package com.rhontproject.acts;

import static com.rhontproject.acts.actsaction.FightArea.fight;
import static com.rhontproject.fabrica.UnitFabric.createZombie;
import static com.rhontproject.stateMethods.SystemUtility.printFromFile;

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
