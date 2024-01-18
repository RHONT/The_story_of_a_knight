package com.rhontproject.typesOfAttack;

import com.rhontproject.unit.Knight;
import com.rhontproject.interfaceAttack.*;
import com.rhontproject.abstractUnitParent.Humanoid;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Описание стандартной атаки
 */
@Service
public class StandardAttackImpl implements EnemyAttack {
    @Override
    public void attackStandardEnemy(Humanoid attacking, Humanoid victim) {

        int criticalStrikeRange = new Random().nextInt(101) + 1;
        int randomPartBody = new Random().nextInt(4);

        if (victim.i_am_fire) {
            victim.param_humanoid[4] = Math.round(victim.copy_param_humanoid[4] / 2);
            victim.chance_to_attack = victim.chance_to_attack_in_fire;
            for (int i = 0; i <= 3; i++) {
                victim.param_humanoid[i] -= 10;
            }
            System.out.println(attacking.name
                    + " Получил урон 30. И теперь теряет здоровье каждый ход (- 10).Урон снижен вдвое! " +
                    "Меткость его упала до "
                    + attacking.chance_to_attack);
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
