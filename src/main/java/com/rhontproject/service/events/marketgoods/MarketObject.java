package com.rhontproject.service.events.marketgoods;

/**
 * Заготовка для объектов продажи
 */
public abstract class MarketObject {
    protected int articular;
    protected String name;
    protected int cost;

    protected MarketObject() {
        initComponent();
    }
    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }
    public abstract void buy();


    public int getArticular(){
        return articular;
    }

    protected abstract void initComponent();
}
