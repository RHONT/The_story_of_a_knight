package com.rhontproject.unit;

import com.rhontproject.interfaceAttack.Attack;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.supports.outputinfo.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("OutLowSmall")
@Scope("prototype")
public class OutLowSmall extends Unit {
    public OutLowSmall(@Qualifier("enemyAttackImpl") Attack attack,
                        @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
                        @Qualifier("printImpl") Printable printable) {
        super(attack, unitBaseFunctional, printable);
        this.name = "Хиляк";
    }

    @Override
    public void setUnit(Unit unit) {

    }

    @Autowired
    @Override
    public void setParam_humanoid(@Value("${outlowsmall}") int[] param_humanoid) {
        this.param_humanoid = param_humanoid;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }
}
