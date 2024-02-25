package com.rhontproject.interfaceAttack;

import com.rhontproject.abstractUnitParent.Unit;

public interface KnightAttack {

    void AttackKnight(Unit attacking, Unit victim);

    default void Armor(int helm, int b, int c, int d) {
    }
}
