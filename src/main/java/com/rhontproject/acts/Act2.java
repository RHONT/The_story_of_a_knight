package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.UnitFabric.createZombie;
import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public class Act2 extends Act {

    @Override
    public void run() {
        printFromFile("[1-1].txt");
        scanner.nextLine();
        eventKnightService.fightArea(createZombie(), createZombie());
        scanner.nextLine();
    }
}
