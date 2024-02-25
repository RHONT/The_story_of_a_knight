package com.rhontproject.unit;

import com.rhontproject.interfaceAttack.EnemyAttack;
import com.rhontproject.supports.basemechanics.UnitStandardBaseImpl;
import com.rhontproject.abstractUnitParent.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("Zombie")
@Scope("prototype")
public class Zombie extends Unit {
    private final EnemyAttack enemyAttack;

    Zombie(EnemyAttack enemyAttack, UnitStandardBaseImpl supportFunction) {
        this.name = "Внезапный мертвец";
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
    public void setParam_humanoid(@Value("${zombie}") int[] param_humanoid) {
        this.param_humanoid = param_humanoid;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }
}

