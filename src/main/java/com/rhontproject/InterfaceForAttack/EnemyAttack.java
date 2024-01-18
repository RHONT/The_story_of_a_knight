package com.rhontproject.InterfaceForAttack;

import com.rhontproject.AbstractUnitParent.Humanoid;


public interface EnemyAttack {

    void attackStandardEnemy(Humanoid attacking, Humanoid victim);

    default void Armor(int a, int b, int c, int d) {
    }

}
