package com.rhontproject.attack;

import com.rhontproject.unit.Unit;
import com.rhontproject.unit.Statless.NameStates;
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
    private NameStates positiveState;
    private NameStates attackState;
    protected String info;



    public Weapon(int power, NameStates positiveState, NameStates attackState) {
        this.power = power;
        this.positiveState = positiveState;
        this.attackState = attackState;
    }

    public Weapon(int power) {
        this.power = power;
    }

    public Weapon(int power, NameStates attackState) {
        this.power = power;
        this.attackState = attackState;
    }

    private void applyNegativeEffect(Unit enemy) {
        enemy.getStateHolder().activeSelectState(attackState);
    }
//todo почему не activeSelectState?
    private void applyPositiveEffect(Unit self) {
        self.getStateHolder().setUnit(self);
    }

    public void attackVictim(int partBody, Unit enemy) {
        if (attackState != null) {
            applyNegativeEffect(enemy);
        }
        if (positiveState != null) {
            applyPositiveEffect(master);
        }
        attackPartBody(partBody, enemy);
        messageService.add(this.info);
        info="";
    }

    abstract protected void attackPartBody(int partBody, Unit enemy);

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
    protected String parts_of_body(int a) {
        Map<Integer, String> parts_of_body = new TreeMap<>();
        parts_of_body.put(1, "голове");
        parts_of_body.put(2, "телу");
        parts_of_body.put(3, "рукам");
        parts_of_body.put(4, "ногам");
        return parts_of_body.get(a);
    }

    /**
     * @param armorOrBodyIndex
     * @return по голове сложнее попасть(-10), по туловищу проще (0)
     * Итоговое значение будет вычитаться из общего шанса попасть.
     */
    protected int calculate_chance_attack(int armorOrBodyIndex) {
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
    protected int missiles_attack(int selectedPartBody) {
        int tempSelectedPartBody = selectedPartBody;
        while (tempSelectedPartBody == selectedPartBody) {
            tempSelectedPartBody = new Random().nextInt(4) + 1;
        }
        return tempSelectedPartBody;
    }

    public int getPower() {
        return power;
    }
}
