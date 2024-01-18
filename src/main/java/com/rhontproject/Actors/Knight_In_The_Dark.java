package com.rhontproject.Actors;

import com.rhontproject.InterfaceForAttack.EnemyAttack;
import com.rhontproject.SupportFunctions.HumanoidStandardSupportImpl;
import com.rhontproject.Param_unit.ParamKnight_In_The_Dark;
import com.rhontproject.AbstractUnitParent.Humanoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("Knight_In_The_Dark")
@Scope("prototype")
public
class Knight_In_The_Dark extends Humanoid {
    final EnemyAttack enemyAttack;

    @Autowired
    Knight_In_The_Dark(ParamKnight_In_The_Dark paramKnight_in_the_dark, EnemyAttack enemyAttack, HumanoidStandardSupportImpl supportFunction) {
        this.name = "Скелет во тьме";
        this.param_humanoid = paramKnight_in_the_dark.array;
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
