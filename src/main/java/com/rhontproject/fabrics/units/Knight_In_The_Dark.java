package com.rhontproject.fabrics.units;

import com.rhontproject.unit.attack.weapons.Weapon;
import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.unit.attack.DuelScenario;
import com.rhontproject.unit.statless.StateHolder;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.inventory.Inventory;
import com.rhontproject.unit.defense.DefenseWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Knight_In_The_Dark")
@Scope("prototype")
public
class Knight_In_The_Dark extends Unit {

    public Knight_In_The_Dark(
            @Qualifier("standardDuelScenarioImpl") DuelScenario duelScenario,
            StateHolder stateHolder,
            BaseAttribute baseAttribute, Inventory inventorySet, DefenseWall defenseWall) {
        super(defenseWall, stateHolder, baseAttribute, inventorySet, duelScenario);
        this.name = "Скелет во тьме";
    }

    @Autowired
    @Override
    public void setWeapon(@Qualifier("getDarkSword") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    @Autowired
    @Override
    protected void setHealth(@Value("${knight_in_the_dark}") int[] health) {
        this.attribute.setCurHealth(health);
    }
}
