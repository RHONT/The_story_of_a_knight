package com.rhontproject.fabrics.units;

import com.rhontproject.unit.attack.DuelScenario;
import com.rhontproject.unit.attack.weapons.Weapon;
import com.rhontproject.unit.statless.StateHolder;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.unit.inventory.Inventory;
import com.rhontproject.unit.defense.DefenseWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("OutLowBridge")
@Scope("prototype")
public
class OutLawBridge extends Unit {

    public OutLawBridge(@Qualifier("standardDuelScenarioImpl") DuelScenario duelScenario,
                        StateHolder stateHolder,
                        BaseAttribute baseAttribute, Inventory inventorySet, DefenseWall defenseWall) {
        super(defenseWall, stateHolder, baseAttribute, inventorySet, duelScenario);
        this.name = "Разбойник";
    }

    @Autowired
    @Override
    public void setWeapon(@Qualifier("getClub") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    @Autowired
    @Override
    public void setHealth(@Value("${outlowbridge}") int[] health) {
        this.attribute.setCurHealth(health);
    }
}
