package com.rhontproject.fabrics.units;

import com.rhontproject.unit.attack.DuelScenario;
import com.rhontproject.unit.attack.weapons.Weapon;
import com.rhontproject.unit.Statless.StateHolder;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.unit.inventory.Inventory;
import com.rhontproject.unit.defense.DefenseWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    public Bear(@Qualifier("standardDuelScenarioImpl") DuelScenario duelScenario,
                StateHolder stateHolder,
                BaseAttribute baseAttribute, Inventory inventorySet, DefenseWall defenseWall) {
        super(defenseWall, stateHolder, baseAttribute, inventorySet, duelScenario);
        this.name = "Зомбо-Медведь";
        this.isHero = false;
    }

    @Autowired
    @Override
    public void setWeapon(@Qualifier("getBearPows") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    @Autowired
    @Override
    public void setHealth(@Value("${bear}") int[] health) {
        this.attribute.setCurHealth(health);
    }
}
