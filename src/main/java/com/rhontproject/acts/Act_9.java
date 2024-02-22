package com.rhontproject.acts;

import static com.rhontproject.stateMethods.Utility.read_file;

public class Act_9 extends Act {
    @Override
    public void run() {
        read_file("[6].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        read_file("[7].txt");
        System.out.println("Нажмиет Enter для продолжения");
    }
}
