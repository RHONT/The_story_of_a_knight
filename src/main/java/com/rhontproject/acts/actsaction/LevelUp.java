package com.rhontproject.acts.actsaction;

import com.rhontproject.acts.Act;

import static com.rhontproject.fabrics.GlobalVariable.eventKnightService;

public final class LevelUp extends Act {
    @Override
    public void run() {
        eventKnightService.level_up();
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
    }
}
