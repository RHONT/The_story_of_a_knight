package com.rhontproject.abstractUnitParent;


import com.rhontproject.interfaceSupporFunctionHumanoid.HumanoidSupportFunctional;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public abstract class Humanoid implements HumanoidSupportFunctional {
    // супер способность волна ветра, бьет по всем врагам.
    public boolean vortex = false;

    public String name;
    // накопительная переменная для отчета о состоянии битвы для каждого юнита
    public String info_str_fight;
    // Горит ли юнит?
    public boolean i_am_fire = false;
    // базовая характеристика шанса на успешное попадение
    public int chance_to_attack = 80;
    // Шанс попасть по противнику если ты горишь
    public int chance_to_attack_in_fire = chance_to_attack - 15;
    // {голова:торс:руки:ноги; сила оружия}
    public int[] param_humanoid = {1, 1, 1, 1, 1};
    // соответственно броня для каждой части тела
    public int[] defense = {0, 0, 0, 0};
    //{Щит на готове, щит в инвенторе,коктейль Молотова,зелье здоровья}
    public int[] param_inventory = {0, 2, 1, 1};
    // копии параметров здоровья и брони для расчетов, для понимания относительности изменений
    public int[] copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    public int[] copy_param_defense = Arrays.copyOfRange(defense, 0, defense.length);

    // каждый юнит несет в себе золото, отдает при смерти
    public int money = new Random().nextInt(150) + 75;

    private HumanoidSupportFunctional humanoidSupportFunctional;


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

    void setParam_humanoid(int a, int b, int c, int d, int e) {
        this.param_humanoid = new int[]{a, b, c, d, e};
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }


    public void setDefense(int a, int b, int c, int d) {
        defense = new int[]{a, b, c, d};
        copy_param_defense = Arrays.copyOfRange(defense, 0, defense.length);
    }

    /**
     * метод, который реализуют интерфейсы из каталога TypesOfAttack
     */
    public abstract void Attack(Humanoid attacking, Humanoid victim);

    @Override
    public void swith_for_level_up() {
        humanoidSupportFunctional.swith_for_level_up();
    }

    @Override
    public void level_up() {
        humanoidSupportFunctional.level_up();

    }

    @Override
    public boolean Humanoid_is_alife() {
        return humanoidSupportFunctional.Humanoid_is_alife();
    }

    @Override
    public void print_health_info() {
        humanoidSupportFunctional.Humanoid_is_alife();

    }

    @Override
    public void down_health() {
        humanoidSupportFunctional.down_health();
    }

    @Override
    public void reborn() {
        humanoidSupportFunctional.reborn();
    }

    @Override
    public void print_defense() {
        humanoidSupportFunctional.print_defense();
    }

    @Override
    public void print_inv_and_money() {
        humanoidSupportFunctional.print_inv_and_money();
    }

    @Override
    public void print_info_fight() {
        humanoidSupportFunctional.print_info_fight();
    }

    @Override
    public void swith_for_halt() {
        humanoidSupportFunctional.swith_for_halt();
    }

    @Override
    public void halt() {
        humanoidSupportFunctional.halt();
    }

    public void setHumanoidSupportFunctional(HumanoidSupportFunctional humanoidSupportFunctional) {
        this.humanoidSupportFunctional = humanoidSupportFunctional;
        humanoidSupportFunctional.setHumanoid(this);
    }
}
