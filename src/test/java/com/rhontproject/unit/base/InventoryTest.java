package com.rhontproject.unit.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void add() {
    }

    @Test
    void use() {
        Inventory inventory=new Inventory();
        inventory.add(InventoryEnum.SHIELD,10);
        assertEquals(9,inventory.use(InventoryEnum.SHIELD));

        inventory.add(InventoryEnum.POTION,0);
        assertEquals(-1,inventory.use(InventoryEnum.POTION));

        inventory.add(InventoryEnum.MOLOTOV,1);
        assertEquals(0,inventory.use(InventoryEnum.MOLOTOV));
    }
}