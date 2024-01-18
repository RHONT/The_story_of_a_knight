package com.rhontproject.Actors;


import com.rhontproject.InterfaceForAttack.KnightAttack;
import com.rhontproject.SupportFunctions.HumanoidStandardSupportImpl;
import com.rhontproject.Param_unit.ParamKnight;
import com.rhontproject.AbstractUnitParent.Humanoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;


@Component("Knight")
public class Knight extends Humanoid {

    final KnightAttack knightAttack;

    @Autowired
    Knight(ParamKnight paramKnight, KnightAttack knightAttack, HumanoidStandardSupportImpl supportFunction) {
        this.name = "Сэр Томас";
        this.param_humanoid = paramKnight.array;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
        this.knightAttack = knightAttack;
        this.setHumanoidSupportFunctional(supportFunction);
    }


    /**
     * @param selectedPartBody на вход индекс части по которой приходиться удар
     * @return на выходе любое другое значение, лишь бы отличалось от входящего
     */
    public static int Missiles_attack(int selectedPartBody) {
        int tempSelectedPartBody = selectedPartBody;
        while (tempSelectedPartBody == selectedPartBody) {
            tempSelectedPartBody = new Random().nextInt(4) + 1;
        }
        return tempSelectedPartBody;
    }

    /**
     * @param armorOrBodyIndex
     * @return по голове сложнее попасть(-10), по туловищу проще (0)
     * Итоговое значение будет вычитаться из общего шанса попасть.
     */
    public static int Calculate_chance_attack(int armorOrBodyIndex) {
        int result;
        switch (armorOrBodyIndex) {
            case 1: {
                result = -10;
                break;
            }
            case 2: {
                result = 0;
                break;
            }
            default: {
                result = -20;
                break;
            }
        }
        return result;
    }

    @Override
    public void Attack(Humanoid attacking, Humanoid victim) {
        knightAttack.AttackKnight(attacking, victim);
    }

    @Override
    public void setHumanoid(Humanoid humanoid) {

    }
}
