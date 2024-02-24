package com.rhontproject.enums;

public enum MarketEnum {
    SHIELD(1, 200),
    POTION_OF_HEALTH(2, 100),
    MOLOTOV(3, 150);

    private final int itemNumber;
    private final int cost;

    MarketEnum(int itemNumber, int cost) {

        this.itemNumber = itemNumber;
        this.cost = cost;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public int getCost() {
        return cost;
    }
}
