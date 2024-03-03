package com.rhontproject.unit.attack.weapons;

import com.rhontproject.unit.Unit;
import com.rhontproject.unit.statless.NameStates;
import org.springframework.stereotype.Component;
import static com.rhontproject.fabrics.global.GlobalVariable.messageService;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
@Component
public abstract class Weapon {
    protected Unit master;
    protected Unit victim;
    protected int power;
    private NameStates negativeState;
    protected String info;
    protected final Random random=new Random();



    protected Weapon(int power,  NameStates negativeState) {
        this.power = power;
        this.negativeState = negativeState;
    }

    protected Weapon(int power) {
        this.power = power;
    }

    private void applyNegativeEffect(Unit enemy) {
        enemy.getStateHolder().activeSelectState(negativeState);
    }

    public void attackVictim(int partBody, Unit enemy) {
        if (negativeState != null) {
            applyNegativeEffect(enemy);
        }
        attackPartBody(partBody, enemy);
        messageService.add(this.info);
        info="";
    }

    protected abstract void attackPartBody(int partBody, Unit enemy);

    public void upPower(int value) {
        power += value;
    }

    public void setMaster(Unit master) {
        this.master = master;
    }

    /**
     * Мапа с нумерацией частей тела,
     * вспомогательный метод
     */
    protected String namePartOfBodyByDigit(int a) {
        Map<Integer, String> partsOfBody = new TreeMap<>();
        partsOfBody.put(1, "голове");
        partsOfBody.put(2, "телу");
        partsOfBody.put(3, "рукам");
        partsOfBody.put(4, "ногам");
        return partsOfBody.get(a);
    }

    /**
     * @param armorOrBodyIndex
     * @return по голове сложнее попасть(-10), по туловищу проще (0)
     * Итоговое значение будет вычитаться из общего шанса попасть.
     */
    protected int calculateChanceAttack(int armorOrBodyIndex) {
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

    /**
     * @param selectedPartBody на вход индекс части по которой приходиться удар
     * @return на выходе любое другое значение, лишь бы отличалось от входящего
     */
    protected int missilesAttack(int selectedPartBody) {
        int tempSelectedPartBody = selectedPartBody;
        while (tempSelectedPartBody == selectedPartBody) {
            tempSelectedPartBody = random.nextInt(4) + 1;
        }
        return tempSelectedPartBody;
    }

    public int getPower() {
        return power;
    }
}
