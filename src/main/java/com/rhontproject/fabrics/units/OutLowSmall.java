package com.rhontproject.fabrics.units;


import com.rhontproject.attack.DuelScenario;
import com.rhontproject.attack.Weapon;
import com.rhontproject.unit.Statless.StateHolder;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.unit.base.Inventory;
import com.rhontproject.unit.defense.DefenseWall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("OutLowSmall")
@Scope("prototype")
public class OutLowSmall extends Unit {
    public OutLowSmall(@Qualifier("standardDuelScenarioImpl") DuelScenario duelScenario,
                       StateHolder stateHolder,
                       BaseAttribute baseAttribute, Inventory inventorySet, DefenseWall defenseWall) {
        super(defenseWall, stateHolder, baseAttribute, inventorySet, duelScenario);
        this.name = "Хиляк";
        this.isHero = false;
    }
    @Autowired
    @Override
    public void setWeapon(@Qualifier("getClub") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    @Autowired
    @Override
    public void setHealth(@Value("${outlowsmall}") int[] health) {
        this.attribute.setCurHealth(health);
    }
}
