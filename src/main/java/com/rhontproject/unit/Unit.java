package com.rhontproject.unit;

import com.rhontproject.unit.attack.DuelScenario;
import com.rhontproject.unit.attack.weapons.Weapon;
import com.rhontproject.unit.statless.StateHolder;
import com.rhontproject.unit.base.AbstractBaseAttribute;
import com.rhontproject.unit.inventory.Inventory;
import com.rhontproject.unit.defense.DefenseWall;

import java.util.*;

/**
 * vortex - супер способность волна ветра, бьет по всем врагам.<br>
 * name - имя персонажа <br>
 * info_str_fight - накопительная переменная для отчета о состоянии битвы для каждого юнита<br>
 * i_am_fire - Горит ли юнит?<br>
 * chance_to_attack - базовая характеристика шанса на успешное попадение<br>
 * chance_to_attack_in_fire - Шанс попасть по противнику если ты горишь<br>
 * param_humanoid - {голова:торс:руки:ноги; сила оружия}<br>
 * defense - броня для каждой части тела<br>
 * param_inventory - {Щит на готове, щит в инвентаре, коктейль Молотова,зелье здоровья}<br>
 * money - каждый юнит несет в себе золото, отдает при смерти<br>
 */
public abstract class Unit {
    public boolean isHero;
    public String name;
    public boolean vortex = false;
    public int chanceAttack = 80;
    public int money = new Random().nextInt(150) + 75;

    private final DefenseWall defenseWall;
    private final StateHolder stateHolder;
    public final AbstractBaseAttribute attribute;
    private Weapon weapon;
    private final Inventory inventorySet;
    private DuelScenario duelScenario;

    public Unit(DefenseWall defenseWall,
                StateHolder stateHolder,
                AbstractBaseAttribute attribute,
                Inventory inventorySet,
                DuelScenario duelScenario) {
        this.defenseWall = defenseWall;
        this.stateHolder = stateHolder;
        this.attribute = attribute;
        this.inventorySet = inventorySet;
        this.duelScenario = duelScenario;
        stateHolder.setUnit(this);
    }

    /**
     * метод, который реализуют интерфейсы из каталога TypesOfAttack
     */
    public void attack(Unit victim) {
        duelScenario.attacking(this, victim);
    }

    public StateHolder getStateHolder() {
        return stateHolder;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Когда выпиваеться зелье здоровья, то показатели выходят за пределы
     * После боя завышенные показатели должны приходить в норму
     */

    public void stabilizeHealth() {
        attribute.stabilizeHealth();
    }

    /**
     * Проверка на жизнеспособность юнита
     */

    public boolean isAlife() {
        return attribute.isAlife();
    }

    protected void setHealth(int[] health) {
        this.attribute.setCurHealth(health);
    }

    public Inventory getInventorySet() {
        return inventorySet;
    }

    public DefenseWall getDefenseWall() {
        return defenseWall;
    }

    public AbstractBaseAttribute getAttribute() {
        return attribute;
    }
}
