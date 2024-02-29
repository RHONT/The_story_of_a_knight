package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public final class Act_1 extends Act {
    @Override
    public void run() {
        printFromFile("[1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
