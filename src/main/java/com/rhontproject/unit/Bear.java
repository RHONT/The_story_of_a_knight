package com.rhontproject.unit;

import com.rhontproject.attack.Attack;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.supports.outputinfo.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public Bear(@Qualifier("enemyAttackImpl") Attack attack,
                @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
                @Qualifier("printImpl") Printable printable) {
        super(attack, unitBaseFunctional, printable);
        this.name = "Зомбо-Медведь";
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
