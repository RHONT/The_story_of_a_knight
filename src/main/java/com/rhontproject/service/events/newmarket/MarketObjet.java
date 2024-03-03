package com.rhontproject.service.events.newmarket;

public interface MarketObjet {
    String getName();
    int getCost();
    boolean buy(int money);
    int getArticular();
}
