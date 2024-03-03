package com.rhontproject.service.events.marketgoods.goods;

import com.rhontproject.service.events.marketgoods.MarketObject;
import com.rhontproject.unit.inventory.InventoryEnum;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static java.lang.System.out;

public class Potion extends MarketObject {
    @Override
    public void buy() {
        if (cost <= knight.getMoney()) {
            knight.getInventorySet().add(InventoryEnum.POTION, 1);
            knight.minusMoney(cost);
            out.println("Вы купили зелье!");
        } else {
            out.println("Невозможно купить зелье. Вам не хватает " + (cost - knight.getMoney()));
        }
    }

    @Override
    protected void initComponent() {

        this.articular = 2;
        this.name = "Зелье здоровья";
        this.cost = 100;
    }
}
