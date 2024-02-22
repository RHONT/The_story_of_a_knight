package com.rhontproject.acts.actsaction;

import com.rhontproject.acts.Act;

public final class LevelUp extends Act {
    @Override
    public void run() {
        knight.level_up();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
