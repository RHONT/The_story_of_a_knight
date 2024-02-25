package com.rhontproject.attack.typeatack;

import com.rhontproject.attack.Attack;
import com.rhontproject.unit.*;
import com.rhontproject.abstractUnitParent.Unit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

@Component
@Scope("prototype")
public class KnightAttackImpl implements Attack {
    private Unit hero;
    private Unit enemy;
    boolean isExit = false;
    int damageMultiplier;
    int indexTargetBody;
    int attackPower;
    int chanceToHitSelectedPartBody;

    private void refreshValue() {
        isExit=false;
        damageMultiplier = getDamageMultiplier();
    }

    @Override
    public void attacking(Unit attacking, Unit victim) {
        refreshValue();
        hero = attacking;
        enemy = victim;
        attackPower = hero.param_humanoid[4];
        out.println("Атакуй! 1 - голова "
                + (hero.chance_to_attack - 10)
                + "% | 2 -тело " + (hero.chance_to_attack)
                + "% | 3 - руки " + (hero.chance_to_attack - 20)
                + "% | 4 - ноги " + (hero.chance_to_attack - 20)
                + "% | Символ  s = (щит)  m = (коктейль Молотова)  p=(Зелье исцеления)");

        while (!isExit) {
            Scanner scanner = new Scanner(System.in);
            String inputConsole = scanner.nextLine().toLowerCase();
            switch (inputConsole) {
                case ("w"):
                    hero.vortex = true;
                    isExit = true;
                    hero.info_str_fight = "Вы разрываете врагов мощным порывом ветра! "
                            + "Урон каждому составил по 40 единиц!";
                    break;
                case ("s"):
                    if (hero.param_inventory[1] >= 2) {
                        hero.param_inventory[0] += 2;
                        hero.param_inventory[1] -= 2;
                        hero.info_str_fight = "Вы достали щит!";
                        isExit = true;
                    } else {
                        out.println("У вас нет щитов");
                    }
                    break;
                case ("m"):
                    if (hero.param_inventory[2] > 0) {
                        for (int i = 0; i < (victim.param_humanoid.length - 1); i++) {
                            victim.param_humanoid[i] -= 30;
                        }
                        hero.info_str_fight = "Противник в огне!";
                        victim.i_am_fire = true;
                        hero.param_inventory[2] -= 1;
                        isExit = true;
                    } else {
                        out.println("У вас нет Молотова");
                    }
                    break;
                case ("p"):
                    if (hero.param_inventory[3] > 0) {
                        for (int i = 0; i < hero.param_inventory.length; i++) {
                            hero.param_humanoid[i] += 70;
                        }
                        hero.param_inventory[3] -= 1;
                        hero.info_str_fight = "Вы исцелились на 70 очков";
                        isExit = true;
                    } else {
                        out.println("У вас нет зелья!");
                    }
                    break;
                // если 1-4 значит идет удар по выбранной части тела, начинаем обработку

                case ("1"):
                case ("2"):
                case ("3"):
                case ("4"):
                    hitToBodyPart(inputConsole);
                    isExit=true;
                    break;
                default:
                    out.println("Введено неправильное значение.\n" +
                            "Атакуйте часть тела (1-4) \n" +
                            "Или совершите действие (Щит, Молотов, Зелье)");
            }
        }
    }

    private void hitToBodyPart(String inputConsole) {

        indexTargetBody = Integer.parseInt(inputConsole);
        chanceToHitSelectedPartBody =
                hero.chance_to_attack + Knight.Calculate_chance_attack(indexTargetBody);

        int damage;
        if (isIncludeInRange()) {
            damage=hitTheEnemy();
            hero.info_str_fight = "Вы нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                    " Противник смог отразить " + (Math.max(attackPower - damage, 0)) + " урона";
        } else {
            if (isIncludeInRangeLastTry()) {
                indexTargetBody = Knight.Missiles_attack(indexTargetBody);
                attackPower /= 2;
                damage = hitTheEnemy();
                hero.info_str_fight = "Вы промазали, но чудом попали по " + Knight.Parts_of_body(indexTargetBody) + ". Урон ваш снижен вдвое" + "\n" +
                        "Вы нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                        " Противник смог отразить " + (attackPower - damage) + " урона";
            } else hero.info_str_fight = "Вы промахнулись!";
        }
    }

    private int hitTheEnemy() {
        int damage;
        damage = (int) (Math.round((attackPower * damageMultiplier) * (enemy.defense[indexTargetBody - 1] > 0 ? 0.25 : 1)));
        enemy.param_humanoid[indexTargetBody - 1] -= damage;
        enemy.defense[indexTargetBody - 1] -= Math.round(enemy.defense[indexTargetBody - 1] > 0 ? attackPower * 0.33 : 0);
        enemy.defense[indexTargetBody - 1] = (Math.max(enemy.defense[indexTargetBody - 1], 0));
        return damage;
    }

    private int getDamageMultiplier() {
        return new Random().nextInt(100) < 20 ? 2 : 1;
    }

    private boolean isIncludeInRange(){
        return  new Random().nextInt(100) <= 50;
    }

    private boolean isIncludeInRangeLastTry(){
        return  new Random().nextInt(100) <= 50;
    }


}

