package com.rhontproject.service.events.marketgoods.goods;

import com.rhontproject.service.events.marketgoods.MarketObject;
import com.rhontproject.unit.defense.HardShield;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static java.lang.System.out;

public class StoneShield extends MarketObject {

    @Override
    public void buy() {
        if (cost <= knight.getMoney()) {
            knight.getDefenseWall().add(new HardShield(), 1);
            knight.minusMoney(cost);
            out.println("Вы купили щит!");
        } else {
            out.println("Невозможно купить щит. Вам не хватает " + (cost - knight.getMoney()));
        }
    }

    @Override
    protected void initComponent() {
        this.articular = 1;
        this.name = "Стальной щит";
        this.cost = 150;
    }
}
