package com.rhontproject.acts;

import static com.rhontproject.stateMethods.Utility.printFromFile;

public class Act_9 extends Act {
    @Override
    public void run() {
        printFromFile("[6].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        printFromFile("[7].txt");
        System.out.println("Нажмиет Enter для продолжения");
    }
}
