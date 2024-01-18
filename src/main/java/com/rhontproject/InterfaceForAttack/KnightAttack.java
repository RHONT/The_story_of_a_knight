package com.rhontproject.InterfaceForAttack;

import com.rhontproject.AbstractUnitParent.Humanoid;

public interface KnightAttack {

    void AttackKnight(Humanoid attacking, Humanoid victim);

    default void Armor(int a, int b, int c, int d) {
    }
}
