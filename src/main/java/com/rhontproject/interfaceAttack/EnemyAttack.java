package com.rhontproject.interfaceAttack;

import com.rhontproject.abstractUnitParent.Unit;


public interface EnemyAttack {

    void attackStandardEnemy(Unit attacking, Unit victim);

    default void Armor(int a, int b, int c, int d) {
    }

}
