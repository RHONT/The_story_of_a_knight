package com.rhontproject.acts;

import com.rhontproject.fabrics.global.StateGame;
import org.springframework.stereotype.Component;

import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public final class Act3 extends Act {
    @Override
    public void run() {
        printFromFile("Thief_1.txt");
        String isRob = scanner.nextLine();
        StateGame.setIsRob(isRob.equals("1"));
    }
}
