package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.service.SystemUtility.printFromFile;

@Component
public class Act8 extends Act {
    @Override
    public void run() {
        printFromFile("[6].txt");
        scanner.nextLine();
        printFromFile("[7].txt");
    }
}
