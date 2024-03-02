package com.rhontproject.acts;

import com.rhontproject.fabrics.global.StateGame;
import com.rhontproject.service.EventKnightService;
import org.springframework.stereotype.Component;

import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public final class Act_3 extends Act {
    @Override
    public void run() {
        printFromFile("Thief_1.txt");
        String isRob = scanner.nextLine();
        StateGame.isRob = (isRob.equals("1"));
    }
}
