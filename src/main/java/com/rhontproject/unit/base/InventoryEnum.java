package com.rhontproject.unit.base;

public enum InventoryEnum {
    SHIELD("Щит"),POTION("Зелье"),MOLOTOV("Молотов");
    private final String name;

    InventoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
