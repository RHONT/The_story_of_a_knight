package com.rhontproject.unit.defense;

public abstract class Defender {
    protected int currentCharges=0;
    protected int baseCharges;

    protected abstract  void active();
    protected abstract  int reflectDamage(int innerDamage);

    public int getCurrentCharges() {
        return currentCharges;
    }
}
