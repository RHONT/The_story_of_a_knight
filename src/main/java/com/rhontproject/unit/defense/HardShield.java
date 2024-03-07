package com.rhontproject.unit.defense;

/**
 * reflectDamage(int innerDamage) реализован здесь примитивно, полностью блокирует урон.
 * Но можно сделать более хитрую логику просчета блокированного урона
 */
public class HardShield extends Defender{
    public HardShield() {
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
