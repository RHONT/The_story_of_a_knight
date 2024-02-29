package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public final class Act_3 extends Act {
    @Override
    public void run() {
        printFromFile("Thief_1.txt");
        String isRob = scanner.nextLine();
        stateGame.isRob = (isRob.equals("1"));
    }
}
