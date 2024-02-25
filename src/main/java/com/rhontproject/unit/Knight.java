package com.rhontproject.unit;


import com.rhontproject.interfaceAttack.Attack;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.supports.outputinfo.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;


@Component("Knight")
public class Knight extends Unit {

    public Knight(@Qualifier("knightAttackImpl") Attack attack,
                  @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
                  @Qualifier("printImpl") Printable printable) {
        super(attack, unitBaseFunctional, printable);
        this.name="Сэр Томас";
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
    public void setUnit(Unit unit) {

    }

    @Autowired
    @Override
    public void setParam_humanoid(@Value("${knight}") int[] param_humanoid) {
        this.param_humanoid = param_humanoid;
        this.copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    }
}
