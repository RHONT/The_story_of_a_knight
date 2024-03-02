package com.rhontproject.acts;


import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.UnitFabric.*;
import static com.rhontproject.service.SystemUtility.printFromFile;
@Component
public class Act_4 extends Act {
    @Override
    public void run() {
        printFromFile("out_law_story.txt");
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        eventKnightService.fightArea(createOutLowSmall(), createOutLowBig());
    }
}
