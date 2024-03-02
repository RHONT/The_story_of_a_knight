package com.rhontproject.unit.defense;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
