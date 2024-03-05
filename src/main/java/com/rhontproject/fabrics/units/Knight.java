package com.rhontproject.fabrics.units;

import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.unit.attack.weapons.Weapon;
import com.rhontproject.unit.attack.DuelScenario;
import com.rhontproject.unit.statless.StateHolder;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.inventory.Inventory;
import com.rhontproject.unit.inventory.InventoryEnum;
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
        this.iAmHero();
    }

    /**
     * Присваиваем персонажу объект с оружием
     * @param weapon
     */
    @Autowired
    @Override
    public void setWeapon(@Qualifier("getKnightWeapon") Weapon weapon) {
        super.setWeapon(weapon);
        this.getWeapon().setMaster(this);
    }

    /**
     * Из properties берем значения для здоровья.
     * setDefense() - устанавливаем броню по умолчания
     * getInventorySet().add - наполняем исходный инвентарь главного героя
     * getDefenseWall().add - щит не входим в стандартный инвентарь, так как у него иная механика.
     * @param health
     */
    @Autowired
    @Override
    protected void setHealth(@Value("${knight}") int[] health) {
        this.getAttribute().setCurHealth(health);
        this.getAttribute().setDefense(30,30,30,30);
        this.getInventorySet().add(InventoryEnum.POTION,2);
        this.getInventorySet().add(InventoryEnum.MOLOTOV,5);
        this.getDefenseWall().add(new HardShield(),3);
    }
}
