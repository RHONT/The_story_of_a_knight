package com.rhontproject.abstractUnitParent;

import com.rhontproject.interfaceAttack.Attack;
import com.rhontproject.supports.outputinfo.Printable;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
@Component
public abstract class Unit implements UnitBaseFunctional, Printable {
    public boolean vortex = false;
    public String name;
    public String info_str_fight;
    public boolean i_am_fire = false;
    public int chance_to_attack = 80;
    public int chance_to_attack_in_fire = chance_to_attack - 15;
    public int[] param_humanoid = {1, 1, 1, 1, 1};
    public int[] defense = {0, 0, 0, 0};
    public int[] param_inventory = {0, 2, 1, 1};
    public int money = new Random().nextInt(150) + 75;

    // копии параметров здоровья и брони для расчетов, для понимания относительности изменений
    public int[] copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    public int[] copy_param_defense = Arrays.copyOfRange(defense, 0, defense.length);

    private Attack attack;
    private final UnitBaseFunctional unitBaseFunctional;
    private final Printable printable;

    public Unit(@Qualifier("knightAttackImpl") Attack attack,
                @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
                @Qualifier("printImpl") Printable printable) {
        this.attack = attack;
        this.unitBaseFunctional = unitBaseFunctional;
        unitBaseFunctional.setUnit(this);
        this.printable = printable;
        printable.setUnit(this);
    }

    /**
     * Мапа с нумерацией частей тела,
     * вспомогательный метод
     */
    public static String Parts_of_body(int a) {
        Map<Integer, String> parts_of_body = new TreeMap<>();
        parts_of_body.put(1, "голове");
        parts_of_body.put(2, "телу");
        parts_of_body.put(3, "рукам");
        parts_of_body.put(4, "ногам");
        return parts_of_body.get(a);
    }

    @Override
    public void setParam_humanoid(int[] param_humanoid) {
        this.param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }

    public void setDefense(int a, int b, int c, int d) {
        defense = new int[]{a, b, c, d};
        copy_param_defense = Arrays.copyOfRange(defense, 0, defense.length);
    }

    /**
     * метод, который реализуют интерфейсы из каталога TypesOfAttack
     */
    public void attack(Unit attacking, Unit victim){
        attack.attacking(this,victim);
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
}
