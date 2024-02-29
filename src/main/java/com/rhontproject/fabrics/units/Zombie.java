package com.rhontproject.fabrics.units;

import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.attack.weapons.Weapon;
import com.rhontproject.attack.Attack;
import com.rhontproject.unit.Statless.StateHolder;
import com.rhontproject.unit.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Zombie")
@Scope("prototype")
public class Zombie extends Unit {
    public Zombie(@Qualifier("standardAttack") Attack attack,
                  StateHolder stateHolder,
                  BaseAttribute baseAttribute) {
        super(stateHolder, baseAttribute, attack);
        this.name = "Внезапный мертвец";
        this.isHero = false;
    }

    @Autowired
    @Override
    public void setWeapon(@Qualifier("getKnightFireWeapon") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    @Autowired
    @Override
    public void setHealth(@Value("${zombie}") int[] health) {
        this.attribute.setCurHealth(health);
    }
}

