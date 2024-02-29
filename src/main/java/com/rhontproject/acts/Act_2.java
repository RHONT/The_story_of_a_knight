package com.rhontproject.acts;

import com.rhontproject.acts.actsaction.FightArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.UnitFabric.createZombie;
import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public class Act_2 extends Act {

    @Autowired
    FightArea fightArea;
    @Override
    public void run() {
        printFromFile("[1-1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fightArea.fight(knight, createZombie(), createZombie());
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
