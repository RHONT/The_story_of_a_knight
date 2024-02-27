package com.rhontproject.unit;


import com.rhontproject.abstractUnitParent.BaseAttribute;
import com.rhontproject.attack.Attack;
import com.rhontproject.newarchitecture.state.StateHolder;
import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.supports.outputinfo.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component("Knight")
public class Knight extends Unit {

    public Knight(@Qualifier("knightAttackImpl") Attack attack,
                  @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
                  @Qualifier("printImpl") Printable printable,
                  StateHolder stateHolder, BaseAttribute baseAttribute) {
        super(stateHolder, baseAttribute, attack, unitBaseFunctional, printable);
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
        switch (armorOrBodyIndex) {
            case 1: {
                return -10;
            }
            case 2: {
                return 0;
            }
            default: {
                return -20;
            }
        }
    }

    @Override
    public void setUnit(Unit unit) {

    }

    @Autowired
    @Override
    public void setHealth(@Value("${knight}") int[] health) {
        this.baseAttribute.setCurHealth(health);
    }
}
