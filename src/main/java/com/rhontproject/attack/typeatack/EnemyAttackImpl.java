package com.rhontproject.attack.typeatack;

import com.rhontproject.attack.Attack;
import com.rhontproject.unit.Knight;
import com.rhontproject.abstractUnitParent.Unit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Описание стандартной атаки
 */
@Component
@Scope("prototype")
public class EnemyAttackImpl implements Attack {

    @Override
    public void attacking(Unit attacking, Unit victim) {

        int criticalStrikeRange = new Random().nextInt(101) + 1;
        int randomPartBody = new Random().nextInt(4);

        if (attacking.i_am_fire) {
            attacking.param_humanoid[4] = attacking.param_humanoid[4] - (attacking.param_humanoid[4] / 8);
            attacking.chance_to_attack = attacking.chance_to_attack_in_fire;
            for (int i = 0; i <= 3; i++) {
                attacking.param_humanoid[i] -= 10;
            }
            System.out.println(attacking.name
                    + " теряет здоровье каждый ход (- 10).Урон снижен вдвое! " +
                    "Текущая меткость:  "
                    + attacking.chance_to_attack+ " и урон снизился!");
        }

        if (victim.param_inventory[0] > 0) {
            victim.param_inventory[0] -= 1;
            attacking.info_str_fight = "Удар пришелся по щиту! Состояние щита: " + victim.param_inventory[0];
        } else {
            if (criticalStrikeRange < attacking.chance_to_attack) {

                if (victim.defense[randomPartBody] > 0) {
                    victim.defense[randomPartBody] -= Math.round(attacking.param_humanoid[4] * 0.33);
                    victim.param_humanoid[randomPartBody] -= Math.round(attacking.param_humanoid[4] * 0.25);
                    victim.defense[randomPartBody] = (Math.max(victim.defense[randomPartBody], 0));

                    attacking.info_str_fight = "Ваш доспех снизил урон, вы получили " +
                            Math.round(attacking.param_humanoid[4] * 0.25) +
                            " Урона по " + Knight.Parts_of_body(randomPartBody + 1) +
                            " | " + " Доспех повредился на " +
                            Math.round(attacking.param_humanoid[4] * 0.33);

                } else {
                    victim.param_humanoid[randomPartBody] -= attacking.param_humanoid[4];
                    attacking.info_str_fight = "Вы  получили урон:" + attacking.param_humanoid[4];
                }
            } else {
                attacking.info_str_fight = attacking.name + " промахнулся!";
            }
        }
    }
}
