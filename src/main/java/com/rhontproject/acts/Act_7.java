package com.rhontproject.acts;

import static com.rhontproject.fabrica.UnitFabric.*;
import static com.rhontproject.stateMethods.Utility.*;

public class Act_7 extends Act {
    @Override
    public void run() {
        read_file("[3].txt");
        scanner.nextLine();
        read_file("[4].txt");
        scanner.nextLine();

        fight_test_vs_shadow(knight, createKnightDark(), createKnight());
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
