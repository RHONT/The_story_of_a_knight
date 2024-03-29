package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.UnitFabric.createBear;
import static com.rhontproject.service.SystemUtility.printFromFile;
@Component
public class Act5 extends Act {
    @Override
    public void run() {
        printFromFile("[2].txt");
        scanner.nextLine();
        eventKnightService.fightArea(createBear());
    }
}
