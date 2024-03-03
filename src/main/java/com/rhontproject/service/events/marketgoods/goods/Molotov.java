package com.rhontproject.service.events.marketgoods.goods;

import com.rhontproject.service.events.marketgoods.MarketObject;
import com.rhontproject.unit.inventory.InventoryEnum;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static java.lang.System.out;

public class Molotov extends MarketObject {
    @Override
    public void buy() {
        if (cost <= knight.getMoney()) {
            knight.getInventorySet().add(InventoryEnum.MOLOTOV,1);
            knight.minusMoney(cost);
            out.println("Вы купили Молотова!");
        } else {
            out.println("Невозможно купить коктейль. Вам не хватает " + (cost - knight.getMoney()));
        }
    }

    @Override
    protected void initComponent() {
        this.articular=3;
        this.name = "Коктейль молотова";
        this.cost = 120;
    }
}
