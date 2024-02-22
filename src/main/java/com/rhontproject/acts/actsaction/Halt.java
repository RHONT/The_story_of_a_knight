package com.rhontproject.acts.actsaction;

import com.rhontproject.acts.Act;

public class Halt extends Act {
    @Override
    public void run() {
        knight.halt();
    }
}
