package com.rhontproject.attack.typeatack;

import com.rhontproject.attack.Attack;
import com.rhontproject.newarchitecture.state.NameStates;
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
    int damageMultiplier;
    int indexTargetBody;
    int attackPower;
    int chanceToHitSelectedPartBody;

    @Override
    public void attacking(Unit attacking, Unit victim) {

        hero = attacking;
        enemy = victim;
        hero.getStateHolder().activate();
        attackPower = hero.baseAttribute.curHealth[4];
        damageMultiplier = getDamageMultiplier();
        out.println(battleOption());

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String inputConsole = scanner.nextLine().toLowerCase();
            switch (inputConsole) {
                case ("w"):
                    activeVortex();
                    return;
                case ("s"):
                    if (hero.inventory[1] >= 2) {
                        getTheShield();
                        return;
                    } else {
                        out.println("У вас нет щитов");
                    }
                    break;
                case ("m"):
                    if (hero.inventory[2] > 0) {
                        enemy.getStateHolder().activeSelectState(NameStates.BURN);
                        return;
                    } else {
                        out.println("У вас нет Молотова");
                    }
                    break;
                case ("p"):
                    if (hero.inventory[3] > 0) {
                        drinkPotion(70);
                        return;
                    } else {
                        out.println("У вас нет зелья!");
                    }
                    break;
                case ("1"):
                case ("2"):
                case ("3"):
                case ("4"):
                    hitToBodyPart(inputConsole);
                    return;
                default:
                    out.println("Введено неправильное значение.\n" +
                            "Атакуйте часть тела (1-4) \n" +
                            "Или совершите действие (Щит, Молотов, Зелье)");
            }
        }
    }

    private String battleOption() {
        return "Атакуй! 1 - голова "
                + (hero.chance_to_attack - 10)
                + "% | 2 -тело " + (hero.chance_to_attack)
                + "% | 3 - руки " + (hero.chance_to_attack - 20)
                + "% | 4 - ноги " + (hero.chance_to_attack - 20)
                + "% | Символ  s = (щит)  m = (коктейль Молотова)  p=(Зелье исцеления)";
    }

    private void activeVortex() {
        hero.vortex = true;
        hero.info_fight = "Вы разрываете врагов мощным порывом ветра! "
                + "Урон каждому составил по 40 единиц!";
    }

    private void getTheShield() {
        hero.inventory[0] += 2;
        hero.inventory[1] -= 2;
        hero.info_fight = "Вы достали щит!";
    }

    private void drinkPotion(int powerPotion) {
        for (int i = 0; i < 4; i++) {
            hero.baseAttribute.curHealth[i] += powerPotion;
        }
        hero.inventory[3] -= 1;
        hero.info_fight = "Вы исцелились на " + powerPotion + " очков";
    }

    private void hitToBodyPart(String inputConsole) {

        indexTargetBody = Integer.parseInt(inputConsole);
        chanceToHitSelectedPartBody =
                hero.chance_to_attack + Knight.Calculate_chance_attack(indexTargetBody);

        int damage;
        if (isIncludeInRange()) {
            damage = hitTheEnemy();
            hero.info_fight = "Вы нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                    " Противник смог отразить " + (Math.max(attackPower - damage, 0)) + " урона";
        } else {
            if (isIncludeInRangeLastTry()) {
                indexTargetBody = Knight.Missiles_attack(indexTargetBody);
                attackPower /= 2;
                damage = hitTheEnemy();
                hero.info_fight = "Вы промазали, но чудом попали по " + Knight.Parts_of_body(indexTargetBody) + ". Урон ваш снижен вдвое" + "\n" +
                        "Вы нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                        " Противник смог отразить " + (attackPower - damage) + " урона";
            } else hero.info_fight = "Вы промахнулись!";
        }
    }

    private int hitTheEnemy() {
        int effectiveDamage = calcEffectiveDamage();
        crushBody(effectiveDamage);
        crushArmor();
        stabilizeArmorValue();
        return effectiveDamage;
    }

    private int calcEffectiveDamage() {
        return (int) (Math.round((attackPower * damageMultiplier) * multiplierIncludingArmor()));
    }

    private void crushBody(int effectiveDamage) {
        enemy.baseAttribute.curHealth[indexTargetBody - 1] -= effectiveDamage;
    }

    private double multiplierIncludingArmor() {
        return enemy.baseAttribute.curDefense[indexTargetBody - 1] > 0 ? 0.25 : 1;
    }

    private void crushArmor() {
        enemy.baseAttribute.curDefense[indexTargetBody - 1] -= (int) Math.round(enemy.baseAttribute.curDefense[indexTargetBody - 1] > 0 ? attackPower * 0.33 : 0);
    }

    private void stabilizeArmorValue() {
        enemy.baseAttribute.curDefense[indexTargetBody - 1] = (Math.max(enemy.baseAttribute.curDefense[indexTargetBody - 1], 0));
    }

    private int getDamageMultiplier() {
        return new Random().nextInt(100) < 20 ? 2 : 1;
    }

    private boolean isIncludeInRange() {
        return new Random().nextInt(100) <= 50;
    }

    private boolean isIncludeInRangeLastTry() {
        return new Random().nextInt(100) <= 50;
    }
}

