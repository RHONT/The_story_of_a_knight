package com.rhontproject.Actors;


import com.rhontproject.InterfaceForAttack.EnemyAttack;
import com.rhontproject.SupportFunctions.HumanoidStandardSupportImpl;
import com.rhontproject.Param_unit.ParamBear;
import com.rhontproject.AbstractUnitParent.Humanoid;
import org.springframework.beans.factory.annotation.Autowired;
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
class Bear extends Humanoid {

    final EnemyAttack enemyAttack;

    @Autowired
    Bear(ParamBear paramBear, EnemyAttack enemyAttack, HumanoidStandardSupportImpl supportFunction) {
        this.name = "Зомбо-Медведь";
        this.param_humanoid = paramBear.array;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
        this.enemyAttack = enemyAttack;
        this.setHumanoidSupportFunctional(supportFunction);
    }

    @Override
    public void Attack(Humanoid attacking, Humanoid victim) {
        enemyAttack.attackStandardEnemy(attacking, victim);
    }

    @Override
    public void setHumanoid(Humanoid humanoid) {

    }
}
