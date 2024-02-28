package com.rhontproject.abstractUnitParent;

import com.rhontproject.newarchitecture.state.NameStates;

import java.util.Random;

public class NormalSword extends Weapon {
    int damageMultiplier;
    int indexTargetBody;
    int chanceToHitSelectedPartBody;

    public NormalSword(int power) {
        super(power);
    }

    public NormalSword(int power, NameStates attackState) {
        super(power, attackState);
    }

    @Override
    protected void attackPartBody(int partBody, Unit enemy) {
        indexTargetBody = partBody;
        damageMultiplier = getDamageMultiplier();
        victim = enemy;
        chanceToHitSelectedPartBody =
                master.chance_to_attack + calculate_chance_attack(indexTargetBody);

        int damage;
        if (isIncludeInRange()) {
            damage = hitTheEnemy();
            master.info_fight = "Вы нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                    " Противник смог отразить " + (Math.max(power - damage, 0)) + " урона";
        } else {
            if (isIncludeInRangeLastTry()) {
                indexTargetBody = missiles_attack(indexTargetBody);
                power /= 2;
                damage = hitTheEnemy();
                master.info_fight = master.name + "промазал, но чудом попал по " + parts_of_body(indexTargetBody) + ". Урон ваш снижен вдвое" + "\n" +
                        "Вы нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                        " Противник смог отразить " + (power - damage) + " урона";
            } else master.info_fight = master.name + " промахнулся!";
        }
    }

    private boolean isIncludeInRange() {
        return new Random().nextInt(100) <= chanceToHitSelectedPartBody;
    }

    private int hitTheEnemy() {
        int effectiveDamage = calcEffectiveDamage();
        crushBody(effectiveDamage);
        crushArmor();
        stabilizeArmorValue();
        return effectiveDamage;
    }

    private int calcEffectiveDamage() {
        return (int) (Math.round((power * damageMultiplier) * multiplierIncludingArmor()));
    }

    private void crushBody(int effectiveDamage) {
        victim.attribute.curHealth[indexTargetBody - 1] -= effectiveDamage;
    }

    private double multiplierIncludingArmor() {
        return victim.attribute.defense[indexTargetBody - 1] > 0 ? 0.25 : 1;
    }

    private void crushArmor() {
        victim.attribute.defense[indexTargetBody - 1] -= (int) Math.round(victim.attribute.defense[indexTargetBody - 1] > 0 ? power * 0.33 : 0);
    }

    private void stabilizeArmorValue() {
        victim.attribute.defense[indexTargetBody - 1] = (Math.max(victim.attribute.defense[indexTargetBody - 1], 0));
    }

    private boolean isIncludeInRangeLastTry() {
        return new Random().nextInt(100) <= 50;
    }

    private int getDamageMultiplier() {
        return new Random().nextInt(100) < 20 ? 2 : 1;
    }


}
