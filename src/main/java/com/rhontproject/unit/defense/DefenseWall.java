package com.rhontproject.unit.defense;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Менеджер по управлению щитом
 * respond(int innerDamage) - если есть еще прочность щита, вернет фактический урон после отражения.
 * loadShield() - если в инвентаре (amountShield) есть щит, то идет активация кол-ва зарядов (у каждого типа щита свое кол-во)
 * getAmountShield() - кол-во щитов в инвентаре
 * getDurability() - текущая прочность активированного щита
 * Defender.class - фактическая реализация типа щита
 * amountShield - указание кол-ва щитов у персонажа
 */
@Component
@Scope("prototype")
public class DefenseWall {

    private int amountShield;
    private Defender typeShield = null;

    public void add(Defender defender, int amountShield) {
        if (typeShield != null && defender.getClass() == typeShield.getClass()) {
            this.amountShield += amountShield;
        } else {
            typeShield = defender;
            this.amountShield = amountShield;
        }
    }

    public int respond(int innerDamage) {
        if (typeShield == null || typeShield.currentCharges == 0) {
            return innerDamage;
        } else {
            return typeShield.reflectDamage(innerDamage);
        }
    }

    public boolean loadShield() {
        if (amountShield == 0) {
            return false;
        } else {
            amountShield--;
            typeShield.active();
            return true;
        }
    }

    public int getAmountShield() {
        return amountShield;
    }

    public int getDurability() {
        return typeShield.getCurrentCharges();
    }
}
