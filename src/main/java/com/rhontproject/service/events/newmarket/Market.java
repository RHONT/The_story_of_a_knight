package com.rhontproject.service.events.newmarket;

public abstract class Market implements MarketObjet {
    protected int articular;
    protected String name;
    protected int cost;

    protected Market(int articular,String name, int cost) {
        this.articular=articular;
        this.name = name;
        this.cost = cost;
    }
}
