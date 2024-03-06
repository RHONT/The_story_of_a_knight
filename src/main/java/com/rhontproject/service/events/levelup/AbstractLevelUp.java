package com.rhontproject.service.events.levelup;

/**
 * Заготовка для объектов повышения уровня
 */
public abstract class AbstractLevelUp {
    protected int articular;
    protected String messageInMenu;

    protected AbstractLevelUp() {
       initComponent();
    }

    public abstract void levelUp();
    protected abstract void initComponent();
    public int getArticular() {
        return articular;
    }

    public String getMessageInMenu() {
        return messageInMenu;
    }
}
