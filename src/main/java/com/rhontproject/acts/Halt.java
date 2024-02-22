package com.rhontproject.acts;

public class Halt extends ActParent {
    @Override
    public void run() {
        knight.halt();
    }
}
