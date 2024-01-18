package com.rhontproject.Actors;

import com.rhontproject.InterfaceForAttack.EnemyAttack;
import com.rhontproject.SupportFunctions.HumanoidStandardSupportImpl;
import com.rhontproject.Param_unit.ParamOutLawBridge;
import com.rhontproject.AbstractUnitParent.Humanoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("OutLowBridge")
@Scope("prototype")
public
class OutLawBridge extends Humanoid {

    final EnemyAttack enemyAttack;

    @Autowired
    OutLawBridge(ParamOutLawBridge paramOutLawBridge, EnemyAttack enemyAttack, HumanoidStandardSupportImpl supportFunction) {
        this.name = "Разбойник";
        this.param_humanoid = paramOutLawBridge.array;
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
