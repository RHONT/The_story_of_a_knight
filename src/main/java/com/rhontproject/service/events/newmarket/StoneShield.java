package com.rhontproject.service.events.newmarket;

import com.rhontproject.service.events.MarketEnum;
import com.rhontproject.unit.defense.HardShield;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static java.lang.System.out;

public class StoneShield extends Market{

    public StoneShield(int articular, String name, int cost) {
        super(articular, name, cost);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public boolean buy(int money) {
        if (cost <= knight.getMoney()) {
            knight.getDefenseWall().add(new HardShield(), 1);
            out.println("Вы купили щит!");
        } else {
            out.println("Невозможно купить щит. Вам не хватает " + (MarketEnum.SHIELD.getCost() - knight.getMoney()));
        }
        return false;
    }

    @Override
    public int getArticular() {
        return articular;
    }
}
