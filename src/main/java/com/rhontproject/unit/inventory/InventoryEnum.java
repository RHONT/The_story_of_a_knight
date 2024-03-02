package com.rhontproject.unit.inventory;

public enum InventoryEnum {
    POTION("Зелье"),MOLOTOV("Молотов");
    private final String name;

    InventoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
