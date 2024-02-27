package com.rhontproject.unit;

import com.rhontproject.abstractUnitParent.BaseAttribute;
import com.rhontproject.attack.Attack;
import com.rhontproject.newarchitecture.state.StateHolder;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.supports.outputinfo.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Zombie")
@Scope("prototype")
public class Zombie extends Unit {
    public Zombie(@Qualifier("enemyAttackImpl") Attack attack,
                  @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
                  @Qualifier("printImpl") Printable printable, StateHolder stateHolder, BaseAttribute baseAttribute) {
        super(stateHolder, baseAttribute, attack, unitBaseFunctional, printable);
        this.name = "Внезапный мертвец";
    }

    @Override
    public void setUnit(Unit unit) {

    }

    @Autowired
    @Override
    public void setHealth(@Value("${zombie}") int[] health) {
        this.baseAttribute.setCurHealth(health);
    }
}

