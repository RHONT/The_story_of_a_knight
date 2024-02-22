package com.rhontproject.acts;

import static com.rhontproject.stateMethods.Utility.read_file;

public final class Act_1 extends Act {
    @Override
    public void run() {
        read_file("[1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
