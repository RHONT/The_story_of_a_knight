package com.rhontproject.fabrics.units;


import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.attack.Weapon;
import com.rhontproject.attack.DuelScenario;
import com.rhontproject.unit.Statless.StateHolder;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.base.Inventory;
import com.rhontproject.unit.base.InventoryEnum;
import com.rhontproject.unit.defense.DefenseWall;
import com.rhontproject.unit.defense.HardShield;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("Knight")
public class Knight extends Unit {
    public Knight(@Qualifier("standardDuelScenarioImpl") DuelScenario duelScenario,
                  StateHolder stateHolder, BaseAttribute baseAttribute, Inventory inventorySet, DefenseWall defenseWall) {
        super(defenseWall, stateHolder, baseAttribute, inventorySet, duelScenario);
        this.name="Сэр Томас";
        this.isHero=true;
    }

    @Autowired
    @Override
    public void setWeapon(@Qualifier("getKnightWeapon") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    @Autowired
    @Override
    public void setHealth(@Value("${knight}") int[] health) {
        this.attribute.setCurHealth(health);
        this.attribute.setDefense(30,30,30,30);
        this.getInventorySet().add(InventoryEnum.POTION,2);
        this.getInventorySet().add(InventoryEnum.MOLOTOV,5);
        this.getDefenseWall().add(new HardShield(),3);
    }
}
