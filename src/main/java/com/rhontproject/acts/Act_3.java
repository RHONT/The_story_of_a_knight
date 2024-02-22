package com.rhontproject.acts;

import static com.rhontproject.stateMethods.Utility.read_file;

public final class Act_3 extends Act {
    @Override
    public void run() {
        read_file("Thief_1.txt");
        String isRob = scanner.nextLine();
        stateGame.isRob = (isRob.equals("1"));
    }
}
