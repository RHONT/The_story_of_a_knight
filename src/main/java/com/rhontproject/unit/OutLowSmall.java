package com.rhontproject.unit;

import com.rhontproject.interfaceAttack.EnemyAttack;
import com.rhontproject.supportFunctions.HumanoidStandardSupportImpl;
import com.rhontproject.abstractUnitParent.Humanoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("OutLowSmall")
@Scope("prototype")
public class OutLowSmall extends Humanoid {

    final EnemyAttack enemyAttack;

    @Autowired
    OutLowSmall( EnemyAttack enemyAttack, HumanoidStandardSupportImpl supportFunction) {
        this.name = "Хиляк";
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

    @Autowired
    public void setParam_humanoid(@Value("${outlowsmall}") int[] param_humanoid) {
        this.param_humanoid = param_humanoid;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }
}
