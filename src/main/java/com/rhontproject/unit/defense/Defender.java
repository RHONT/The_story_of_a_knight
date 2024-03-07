package com.rhontproject.unit.defense;

/**
 * База для создания различных щитов
 * active() - активация щита, установление базового кол-ва отражений (baseCharges), после каждого удара
 * currentCharges - текущее кол-во отражений, после каждого удара (-1) к текущему отражению
 */
public abstract class Defender {
    protected int currentCharges=0;
    protected int baseCharges;

    protected abstract  void active();
    protected abstract  int reflectDamage(int innerDamage);

    public int getCurrentCharges() {
        return currentCharges;
    }
}
