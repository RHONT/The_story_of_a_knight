package com.rhontproject.units;


import com.rhontproject.abstractUnitParent.BaseAttribute;
import com.rhontproject.abstractUnitParent.Weapon;
import com.rhontproject.attack.Attack;
import com.rhontproject.newarchitecture.state.StateHolder;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
import com.rhontproject.abstractUnitParent.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("Knight")
public class Knight extends Unit {
    public Knight(@Qualifier("standardAttack") Attack attack,
                  @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
                  StateHolder stateHolder, BaseAttribute baseAttribute) {
        super(stateHolder, baseAttribute, attack, unitBaseFunctional);
        this.name="Сэр Томас";
        this.isHero=true;
    }

    @Override
    public void setUnit(Unit unit) {
    }

    @Autowired
    @Override
    public void setWeapon(@Qualifier("getKnightFireWeapon") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    @Autowired
    @Override
    public void setHealth(@Value("${knight}") int[] health) {
        this.attribute.setCurHealth(health);
    }
}
