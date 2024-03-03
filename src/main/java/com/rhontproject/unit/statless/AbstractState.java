package com.rhontproject.unit.statless;

public abstract class AbstractState implements StateAction {
    protected int count;
    protected String message;

    protected abstract void initMessage();

    protected AbstractState() {
        initMessage();
    }
}
