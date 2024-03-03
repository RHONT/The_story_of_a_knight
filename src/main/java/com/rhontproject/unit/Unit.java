package com.rhontproject.unit;

import com.rhontproject.unit.attack.DuelScenario;
import com.rhontproject.unit.attack.weapons.Weapon;
import com.rhontproject.unit.statless.StateHolder;
import com.rhontproject.unit.base.AbstractBaseAttribute;
import com.rhontproject.unit.inventory.Inventory;
import com.rhontproject.unit.defense.DefenseWall;

import java.util.*;

public abstract class Unit {
    private boolean isHero=false;
    protected String name;
    public boolean vortex = false;
    private int chanceAttack = 80;
    protected final Random random=new Random();
    private int money = random.nextInt(150) + 75;

    private final DefenseWall defenseWall;
    private final StateHolder stateHolder;
    public final AbstractBaseAttribute attribute;
    private Weapon weapon;
    private final Inventory inventorySet;
    private final DuelScenario duelScenario;

    protected Unit(DefenseWall defenseWall,
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
     * Когда выпивается зелье здоровья, то показатели выходят за пределы
     * После боя завышенные показатели должны приходить в норму
     */

    public void stabilizeHealth() {
        attribute.stabilizeHealth();
    }

    /**
     * Проверка на жизнеспособность персонажа
     */

    public boolean isAlive() {
        return attribute.isAlife();
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void plusMoney(int money){
        this.money+=money;
    }

    public void minusMoney(int money){
        this.money-=money;
    }

    public String getName() {
        return name;
    }

    public boolean isHero() {
        return isHero;
    }
    protected void iAmHero(){
        isHero=true;
    }

    public void plusChanceAttack(int value){
        chanceAttack+=value;
    }
    public void minusChanceAttack(int value){
        chanceAttack-=value;
    }

    public int getChanceAttack() {
        return chanceAttack;
    }
}
