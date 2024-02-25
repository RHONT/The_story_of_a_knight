package com.rhontproject.typesOfAttack;

import com.rhontproject.unit.*;
import com.rhontproject.interfaceAttack.KnightAttack;
import com.rhontproject.abstractUnitParent.Unit;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

@Service
public class KnightAttackImpl implements KnightAttack {
    @Override
    public void AttackKnight(Unit attacking, Unit victim) {

        String checkInputConsoleString;
        boolean stringAccepted = false;

        int criticalDamageRandom;
        int chanceDamageRandom;
        int temp_attack;
        int armorOrBodyIndex;
        int damageMultiplier = 1;
        int chanceToHitSelectedPartBody;
        int damage_to_enemy;

        temp_attack = attacking.param_humanoid[4];

        out.println("Атакуй! 1 - голова "
                + (attacking.chance_to_attack - 10)
                + "% | 2 -тело " + (attacking.chance_to_attack)
                + "% | 3 - руки " + (attacking.chance_to_attack - 20)
                + "% | 4 - ноги " + (attacking.chance_to_attack - 20)
                + "% | Символ  s = (щит)  m = (коктейль Молотова)  p=(Зелье исцеления)");

        while (!stringAccepted) {
            Scanner str_war = new Scanner(in);
            checkInputConsoleString = str_war.nextLine().toLowerCase();
            switch (checkInputConsoleString) {
                case ("w"):
                    attacking.vortex = true;
                    stringAccepted = true;
                    attacking.info_str_fight = "Вы разрываете врагов мощным порывом ветра! "
                            + "Урон каждому составил по 40 единиц!";
                    break;
                case ("s"):
                    if (attacking.param_inventory[1] >= 2) {
                        attacking.param_inventory[0] += 2;
                        attacking.param_inventory[1] -= 2;
                        attacking.info_str_fight = "Вы достали щит!";
                        stringAccepted = true;
                    } else {
                        out.println("У вас нет щитов");
                    }
                    break;
                case ("m"):
                    if (attacking.param_inventory[2] > 0) {
                        for (int i = 0; i < (victim.param_humanoid.length - 1); i++) {
                            victim.param_humanoid[i] -= 30;
                        }
                        attacking.info_str_fight = "Противник в огне!";
                        victim.i_am_fire = true;
                        attacking.param_inventory[2] -= 1;
                        stringAccepted = true;
                    } else {
                        out.println("У вас нет Молотова");
                    }
                    break;
                case ("p"):
                    if (attacking.param_inventory[3] > 0) {
                        for (int i = 0; i < attacking.param_inventory.length; i++) {
                            attacking.param_humanoid[i] += 70;
                        }
                        attacking.param_inventory[3] -= 1;
                        attacking.info_str_fight = "Вы исцелились на 70 очков";
                        stringAccepted = true;
                    } else {
                        out.println("У вас нет зелья!");
                    }
                    break;
                // если 1-4 значит идет удар по выбранной части тела, начинаем обработку
                case ("1"):
                case ("2"):
                case ("3"):
                case ("4"):
                    armorOrBodyIndex = Integer.parseInt(checkInputConsoleString);

                    chanceToHitSelectedPartBody = attacking.chance_to_attack;
                    chanceToHitSelectedPartBody += Knight.Calculate_chance_attack(armorOrBodyIndex);

                    stringAccepted = true;

                    criticalDamageRandom = new Random().nextInt(100);
                    chanceDamageRandom = new Random().nextInt(100);

                    if (criticalDamageRandom < 20) {
                        damageMultiplier = 2;
                    }

                    if (chanceDamageRandom <= chanceToHitSelectedPartBody) {

                        damage_to_enemy = getDamage_to_enemy(victim, temp_attack, armorOrBodyIndex, damageMultiplier);
                        attacking.info_str_fight = "Вы нанесли урон: " + damage_to_enemy + (damageMultiplier == 2 ? " Критический удар!" : "") +
                                " Противник смог отразить " + (Math.max(temp_attack - damage_to_enemy, 0)) + " урона";
                    } else {
                        chanceDamageRandom = new Random().nextInt(100);
                        if (chanceDamageRandom <= 50) {
                            armorOrBodyIndex = Knight.Missiles_attack(armorOrBodyIndex);
                            temp_attack /= 2;

                            damage_to_enemy = getDamage_to_enemy(victim, temp_attack, armorOrBodyIndex, damageMultiplier);

                            attacking.info_str_fight = "Вы промазали, но чудом попали по " + Knight.Parts_of_body(armorOrBodyIndex) + ". Урон ваш снижен вдвое" + "\n" +
                                    "Вы нанесли урон: " + damage_to_enemy + (damageMultiplier == 2 ? " Критический удар!" : "") +
                                    " Противник смог отразить " + (temp_attack - damage_to_enemy) + " урона";
                        } else attacking.info_str_fight = "Вы промахнулись!";
                    }
                    break;

                default:
                    out.println("Введено неправильное значение.\n" +
                            "Атакуйте часть тела (1-4) \n" +
                            "Или совершите действие (Щит, Молотов, Зелье)");
            }

        }

    }

    private int getDamage_to_enemy(Unit victim, int temp_attack, int armorOrBodyIndex, int damageMultiplier) {
        int damage_to_enemy;
        damage_to_enemy = (int) (Math.round((temp_attack * damageMultiplier) * (victim.defense[armorOrBodyIndex - 1] > 0 ? 0.25 : 1)));
        victim.param_humanoid[armorOrBodyIndex - 1] -= damage_to_enemy;
        victim.defense[armorOrBodyIndex - 1] -= Math.round(victim.defense[armorOrBodyIndex - 1] > 0 ? temp_attack * 0.33 : 0);
        victim.defense[armorOrBodyIndex - 1] = (Math.max(victim.defense[armorOrBodyIndex - 1], 0));
        return damage_to_enemy;
    }


}

