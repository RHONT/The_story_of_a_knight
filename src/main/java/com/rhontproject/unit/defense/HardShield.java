package com.rhontproject.unit.defense;

public class HardShield extends Defender{
    {
        baseCharges=5;
    }

    @Override
    protected void active() {
        currentCharges=baseCharges;
    }

    @Override
    protected int reflectDamage(int innerDamage) {
        currentCharges--;
        return 0;
    }
}
