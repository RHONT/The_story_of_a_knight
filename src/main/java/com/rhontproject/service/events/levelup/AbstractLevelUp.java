package com.rhontproject.service.events.levelup;

public abstract class AbstractLevelUp {
    protected int articular;

    protected AbstractLevelUp() {
       initComponent();
    }

    public abstract void levelUp();
    protected abstract void initComponent();
    public int getArticular() {
        return articular;
    }
}
