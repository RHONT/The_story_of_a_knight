package com.rhontproject.acts.actsaction;

import com.rhontproject.acts.Act;

import static com.rhontproject.fabrics.GlobalVariable.eventKnightService;

public class Halt extends Act {
    @Override
    public void run() {
        eventKnightService.halt();
    }
}
