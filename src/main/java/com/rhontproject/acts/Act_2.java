package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.UnitFabric.createZombie;
import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public class Act_2 extends Act {
    @Override
    public void run() {
        printFromFile("[1-1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        eventKnightService.fightArea(createZombie(), createZombie());
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
