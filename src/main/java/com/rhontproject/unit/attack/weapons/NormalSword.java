package com.rhontproject.unit.attack.weapons;

import com.rhontproject.unit.Unit;
import com.rhontproject.unit.statless.NameStates;

public class NormalSword extends Weapon {
    int damageMultiplier;
    int indexTargetBody;
    int chanceToHitSelectedPartBody;
    int currentPower;

    public NormalSword(int power) {
        super(power);
    }

    public NormalSword(int power, NameStates attackState) {
        super(power, attackState);
    }

    @Override
    protected void attackPartBody(int partBody, Unit enemy) {
        currentPower = enemy.getDefenseWall().respond(power);
        indexTargetBody = partBody;
        damageMultiplier = getDamageMultiplier();
        victim = enemy;
        chanceToHitSelectedPartBody =
                master.chanceAttack + calculateChanceAttack(indexTargetBody);

        int damage;
        if (isIncludeInRange()) {

            damage = hitTheEnemy();
            info = master.name + " нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                    " Противник смог отразить " + (Math.max(currentPower - damage, 0)) + " урона";
        } else {
            if (isIncludeInRangeLastTry()) {
                indexTargetBody = missilesAttack(indexTargetBody);
                currentPower /= 2;
                damage = hitTheEnemy();
                info = master.name + " промазал, но чудом попал по " + namePartOfBodyByDigit(indexTargetBody) + ". Урон ваш снижен вдвое" + "\n" +
                        master.name + " нанесли урон: " + damage + (damageMultiplier == 2 ? " Критический удар!" : "") +
                        " Противник смог отразить " + (currentPower - damage) + " урона";
            } else info = master.name + " промахнулся!";
        }
    }

    private boolean isIncludeInRange() {
        return random.nextInt(100) <= chanceToHitSelectedPartBody;
    }

    private int hitTheEnemy() {

        int effectiveDamage = calcEffectiveDamage();
        crushBody(effectiveDamage);
        crushArmor(effectiveDamage);
        stabilizeArmorValue();
        return effectiveDamage;
    }

    private int calcEffectiveDamage() {

        return (int) (Math.round((currentPower * damageMultiplier) * multiplierIncludingArmor()));
    }

    private void crushBody(int effectiveDamage) {
        victim.attribute.curHealth[indexTargetBody - 1] -= effectiveDamage;
    }

    private double multiplierIncludingArmor() {
        return victim.attribute.defense[indexTargetBody - 1] > 0 ? 0.25 : 1;
    }

    private void crushArmor(int effectiveDamage) {
        victim.attribute.defense[indexTargetBody - 1] -=
                (int) Math.round(victim.attribute.defense[indexTargetBody - 1] > 0 ? effectiveDamage * 0.33 : 0);
    }

    private void stabilizeArmorValue() {
        victim.attribute.defense[indexTargetBody - 1] = (Math.max(victim.attribute.defense[indexTargetBody - 1], 0));
    }

    private boolean isIncludeInRangeLastTry() {
        return random.nextInt(100) <= 50;
    }

    private int getDamageMultiplier() {
        return random.nextInt(100) < 20 ? 2 : 1;
    }

}
