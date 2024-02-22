package com.rhontproject.acts;

import static com.rhontproject.fabrica.UnitFabric.createZombie;
import static com.rhontproject.stateMethods.Utility.fight;
import static com.rhontproject.stateMethods.Utility.read_file;

public class Act_2 extends ActParent{

    @Override
    public void run() {
        read_file("[1-1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fight(knight, createZombie(), createZombie());
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
