package com.rhontproject.unit;

import com.rhontproject.interfaceAttack.EnemyAttack;
import com.rhontproject.supports.basemechanics.UnitStandardBaseImpl;
import com.rhontproject.abstractUnitParent.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * param_humanoid - массив из 5 значений.
 * 1-4 части тела
 * 5 сила орудия
 * EnemyAttack -
 */

@Component("Bear")
@Scope("prototype")
public
class Bear extends Unit {
    private final EnemyAttack enemyAttack;

    Bear(EnemyAttack enemyAttack, UnitStandardBaseImpl supportFunction) {
        this.name = "Зомбо-Медведь";
        this.enemyAttack = enemyAttack;
        this.setHumanoidSupportFunctional(supportFunction);
    }

    @Override
    public void attack(Unit attacking, Unit victim) {
        enemyAttack.attackStandardEnemy(attacking, victim);
    }

    @Override
    public void setUnit(Unit unit) {
    }

    @Autowired
    @Override
    public void setParam_humanoid(@Value("${bear}") int[] param_humanoid) {
        this.param_humanoid = param_humanoid;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }
}
