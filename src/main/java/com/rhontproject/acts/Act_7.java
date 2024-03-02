package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.ActsFabric.halt;
import static com.rhontproject.fabrics.ActsFabric.levelUp;
import static com.rhontproject.fabrics.UnitFabric.createKnightDark;
import static com.rhontproject.service.SystemUtility.*;
@Component
public class Act_7 extends Act {

    @Override
    public void run() {
        printFromFile("[3].txt");
        scanner.nextLine();
        printFromFile("[4].txt");
        scanner.nextLine();
        eventKnightService.fightArea(createKnightDark());
        System.out.println("Нажмиет Enter для продолжения");

        halt();
        levelUp();

        printFromFile("[5].txt");
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        eventKnightService.fightArea(createKnightDark(), createKnightDark());
    }
}
