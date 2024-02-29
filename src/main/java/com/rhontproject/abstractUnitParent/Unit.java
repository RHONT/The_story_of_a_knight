package com.rhontproject.abstractUnitParent;

import com.rhontproject.attack.Attack;
import com.rhontproject.newarchitecture.state.StateHolder;
import com.rhontproject.supports.outputinfo.Printable;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;

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
public abstract class Unit implements UnitBaseFunctional, Printable {
    private final StateHolder stateHolder;
    public boolean isHero;
    public boolean vortex = false;
    public String name;
    public int chance_to_attack = 80;
    public int[] inventory = {0, 2, 1, 1};
    public int money = new Random().nextInt(150) + 75;
    public final BaseAttribute attribute;
    private Weapon weapon;
    private Inventorys inventorys;
    private Attack attack;
    private final UnitBaseFunctional unitBaseFunctional;
    private final Printable printable;

    public Unit(StateHolder stateHolder, BaseAttribute attribute, Attack attack,
                UnitBaseFunctional unitBaseFunctional,
                Printable printable) {
        this.stateHolder = stateHolder;
        this.attribute = attribute;
        this.attack = attack;
        this.unitBaseFunctional = unitBaseFunctional;
        unitBaseFunctional.setUnit(this);
        this.printable = printable;
        printable.setUnit(this);
        stateHolder.setUnit(this);
    }



    /**
     * метод, который реализуют интерфейсы из каталога TypesOfAttack
     */
    public void attack(Unit victim) {
        attack.attacking(this, victim);
    }

    @Override
    public void level_up() {
        unitBaseFunctional.level_up();
    }

    @Override
    public boolean isAlife() {
        return unitBaseFunctional.isAlife();
    }

    @Override
    public void printHealthDefense() {
        printable.printHealthDefense();
    }

    @Override
    public void stabilizeHealth() {
        unitBaseFunctional.stabilizeHealth();
    }

    @Override
    public void reborn() {
        unitBaseFunctional.reborn();
    }

    @Override
    public void printDefense() {
        printable.printDefense();
    }

    @Override
    public void printInventory() {
        printable.printInventory();
    }

    @Override
    public void printInfoFight() {
        printable.printInfoFight();
    }

    @Override
    public void halt() {
        unitBaseFunctional.halt();
    }

    public UnitBaseFunctional getUnitBaseFunctional() {
        return unitBaseFunctional;
    }

    public Printable getPrintable() {
        return printable;
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

    public void setHero(boolean hero) {
        isHero = hero;
    }
}
