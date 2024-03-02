package com.rhontproject.unit.base;

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
