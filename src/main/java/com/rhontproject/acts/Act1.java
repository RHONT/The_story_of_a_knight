package com.rhontproject.acts;

import org.springframework.stereotype.Component;

import static com.rhontproject.service.SystemUtility.printFromFile;
import static java.lang.System.*;

@Component
public final class Act1 extends Act {
    @Override
    public void run() {
        printFromFile("[1].txt");
        scanner.nextLine();
    }
}
