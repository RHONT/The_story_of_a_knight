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
    private Unit attacking;
    private Unit victim;
    int attackPower;

    @Override
    public void attacking(Unit attacking, Unit victim) {

        this.attacking = attacking;
        this.victim = victim;
        this.attacking.getStateHolder().activate();
        attackPower = this.attacking.attribute.curHealth[4];
        out.println(battleOption());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputConsole;
            if (!attacking.isHero) {
                 inputConsole=String.valueOf((new Random().nextInt(3)+1));
            } else {
                 inputConsole = scanner.nextLine().toLowerCase();
            }
            switch (inputConsole) {
                case ("w"):
                    activeVortex();
                    return;
                case ("s"):
                    if (this.attacking.inventory[1] >= 2) {
                        getTheShield();
                        return;
                    } else {
                        out.println("У вас нет щитов");
                    }
                    break;
                case ("m"):
                    if (this.attacking.inventory[2] > 0) {
                        this.victim.getStateHolder().activeSelectState(NameStates.BURN);
                        return;
                    } else {
                        out.println("У вас нет Молотова");
                    }
                    break;
                case ("p"):
                    if (this.attacking.inventory[3] > 0) {
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
                    attacking.getWeapon().attackVictim(Integer.parseInt(inputConsole),victim);
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
                + (attacking.chance_to_attack - 10)
                + "% | 2 -тело " + (attacking.chance_to_attack)
                + "% | 3 - руки " + (attacking.chance_to_attack - 20)
                + "% | 4 - ноги " + (attacking.chance_to_attack - 20)
                + "% | Символ  s = (щит)  m = (коктейль Молотова)  p=(Зелье исцеления)";
    }

    private void activeVortex() {
        attacking.vortex = true;
        attacking.info_fight = "Вы разрываете врагов мощным порывом ветра! "
                + "Урон каждому составил по 40 единиц!";
    }

    private void getTheShield() {
        attacking.inventory[0] += 2;
        attacking.inventory[1] -= 2;
        attacking.info_fight = "Вы достали щит!";
    }

    private void drinkPotion(int powerPotion) {
        for (int i = 0; i < 4; i++) {
            attacking.attribute.curHealth[i] += powerPotion;
        }
        attacking.inventory[3] -= 1;
        attacking.info_fight = "Вы исцелились на " + powerPotion + " очков";
    }
}

