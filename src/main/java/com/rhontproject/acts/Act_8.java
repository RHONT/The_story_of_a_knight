package com.rhontproject.acts;

import static com.rhontproject.stateMethods.SystemUtility.printFromFile;

public class Act_8 extends Act {
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
