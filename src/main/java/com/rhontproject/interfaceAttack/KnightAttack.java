package com.rhontproject.interfaceAttack;

import com.rhontproject.abstractUnitParent.Humanoid;

public interface KnightAttack {

    void AttackKnight(Humanoid attacking, Humanoid victim);

    default void Armor(int a, int b, int c, int d) {
    }
}