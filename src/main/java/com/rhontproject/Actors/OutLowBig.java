package com.rhontproject.Actors;

import com.rhontproject.InterfaceForAttack.EnemyAttack;
import com.rhontproject.SupportFunctions.HumanoidStandardSupportImpl;
import com.rhontproject.Param_unit.ParamOutLawBig;
import com.rhontproject.AbstractUnitParent.Humanoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("OutLowBig")
@Scope("prototype")
public
class OutLowBig extends Humanoid {

    final EnemyAttack enemyAttack;

    @Autowired
    OutLowBig(ParamOutLawBig paramOutLawBig, EnemyAttack enemyAttack, HumanoidStandardSupportImpl supportFunction) {
        this.name = "Здоровяк";
        this.param_humanoid = paramOutLawBig.array;
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
