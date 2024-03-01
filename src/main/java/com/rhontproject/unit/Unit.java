package com.rhontproject.unit;

import com.rhontproject.attack.DuelScenario;
import com.rhontproject.attack.Weapon;
import com.rhontproject.unit.Statless.StateHolder;
import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.unit.base.Inventory;

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
    private final StateHolder stateHolder;
    public boolean isHero;
    public boolean vortex = false;
    public String name;
    public int chance_to_attack = 80;
    public int[] inventory = {0, 2, 1, 1};
    public int money = new Random().nextInt(150) + 75;
    public final BaseAttribute attribute;
    private Weapon weapon;
    private final Inventory inventorySet;
    private DuelScenario duelScenario;

    public Unit(StateHolder stateHolder, BaseAttribute attribute, Inventory inventorySet, DuelScenario duelScenario) {
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
        for (int i = 0; i < 4; i++) {
            if (this.attribute.baseHealth[i] < this.attribute.curHealth[i]) {
                this.attribute.curHealth[i] = this.attribute.baseHealth[i];
            }
        }
    }

    /**
     * Проверка на жизнеспособность юнита
     */

    public boolean isAlife() {
        boolean life = false;
        for (int checkPartOfBody : this.attribute.curHealth) {
            if (checkPartOfBody <= 0) {
                life = false;
                break;
            } else life = true;
        }
        return life;
    }

    /**
     * Воскрешение юнита
     * Чтобы была возможность использовать его вновь, не создавая еще один экземпляр
     */
    public void reborn() {
        this.attribute.curHealth = Arrays.copyOfRange(this.attribute.baseHealth, 0, 5);
        this.chance_to_attack = 80;
    }
    protected void setHealth(int[] health) {
        this.attribute.setCurHealth(health);
    }

    public Inventory getInventorySet() {
        return inventorySet;
    }
}
