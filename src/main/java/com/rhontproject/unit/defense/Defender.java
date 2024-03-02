package com.rhontproject.unit.defense;

public abstract class Defender {
    protected int currentCharges=0;
    protected int baseCharges;

    abstract protected void active();
    abstract protected int reflectDamage(int innerDamage);
}
