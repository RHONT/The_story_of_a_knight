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
        attacking.getStateHolder().activate();
        int criticalStrikeRange = new Random().nextInt(101) + 1;
        int randomPartBody = new Random().nextInt(4);

        if (victim.inventory[0] > 0) {
            victim.inventory[0] -= 1;
            attacking.info_fight = "Удар пришелся по щиту! Состояние щита: " + victim.inventory[0];
        } else {
            if (criticalStrikeRange < attacking.chance_to_attack) {

                if (victim.baseAttribute.curDefense[randomPartBody] > 0) {
                    victim.baseAttribute.curDefense[randomPartBody] -= (int) Math.round(attacking.baseAttribute.curHealth[4] * 0.33);
                    victim.baseAttribute.curHealth[randomPartBody] -= (int) Math.round(attacking.baseAttribute.curHealth[4] * 0.25);
                    victim.baseAttribute.curDefense[randomPartBody] = (Math.max(victim.baseAttribute.curDefense[randomPartBody], 0));

                    attacking.info_fight = "Ваш доспех снизил урон, вы получили " +
                            Math.round(attacking.baseAttribute.curHealth[4] * 0.25) +
                            " Урона по " + Knight.Parts_of_body(randomPartBody + 1) +
                            " | " + " Доспех повредился на " +
                            Math.round(attacking.baseAttribute.curHealth[4] * 0.33);

                } else {
                    victim.baseAttribute.curHealth[randomPartBody] -= attacking.baseAttribute.curHealth[4];
                    attacking.info_fight = "Вы  получили урон:" + attacking.baseAttribute.curHealth[4];
                }
            } else {
                attacking.info_fight = attacking.name + " промахнулся!";
            }
        }
    }
}
