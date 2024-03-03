package com.rhontproject.unit.statless;

public abstract class AbstractState implements StateAction {
    protected int count;
    protected String message;
    abstract protected void initMessage();
    public AbstractState() {
        initMessage();
    }
}
