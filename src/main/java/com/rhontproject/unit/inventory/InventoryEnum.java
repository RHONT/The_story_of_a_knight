package com.rhontproject.unit.inventory;

public enum InventoryEnum {
    POTION("Зелье","p"),MOLOTOV("Молотов","m");
    private final String name;
    private final String hotKey;

    InventoryEnum(String name, String hotKey) {
        this.name = name;
        this.hotKey=hotKey;
    }

    public String getName() {
        return name;
    }

    public String getHotKey() {
        return hotKey;
    }
}
