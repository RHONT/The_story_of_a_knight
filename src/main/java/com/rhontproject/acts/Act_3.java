package com.rhontproject.acts;

import static com.rhontproject.stateMethods.Utility.printFromFile;

public final class Act_3 extends Act {
    @Override
    public void run() {
        printFromFile("Thief_1.txt");
        String isRob = scanner.nextLine();
        stateGame.isRob = (isRob.equals("1"));
    }
}
