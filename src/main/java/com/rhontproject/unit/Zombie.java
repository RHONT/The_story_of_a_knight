package com.rhontproject.unit;


import com.rhontproject.interfaceAttack.EnemyAttack;
import com.rhontproject.supportFunctions.HumanoidStandardSupportImpl;
import com.rhontproject.abstractUnitParent.Humanoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("Zombi")
@Scope("prototype")
public class Zombie extends Humanoid {

    final EnemyAttack enemyAttack;

    @Autowired
    Zombie(EnemyAttack enemyAttack, HumanoidStandardSupportImpl supportFunction) {
        this.name = "Внезапный мертвец";
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
    @Override
    public void setParam_humanoid(@Value("${zombie}") int[] param_humanoid) {
        this.param_humanoid = param_humanoid;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }
}

