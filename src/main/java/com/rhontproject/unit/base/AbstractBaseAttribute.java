package com.rhontproject.unit.base;

import java.util.Arrays;


public abstract class AbstractBaseAttribute {
    public int[] curHealth = {1, 1, 1, 1};
    public int[] defense = {0, 0, 0, 0};
    public int[] baseHealth;

    public void setCurHealth(int[] curHealth) {
        this.curHealth = Arrays.copyOf(curHealth, curHealth.length);
        this.baseHealth = Arrays.copyOf(curHealth, curHealth.length);
    }

    public void setDefense(int helm, int tors, int hand, int leg) {
        this.defense = new int[]{helm, tors, hand, leg};
    }

    /**
     * Когда выпиваеться зелье здоровья, то показатели выходят за пределы
     * После боя завышенные показатели должны приходить в норму
     */
    public void stabilizeHealth() {
        for (int i = 0; i < curHealth.length; i++) {
            if (baseHealth[i] < curHealth[i]) {
                curHealth[i] = baseHealth[i];
            }
        }
    }
    /**
     * Проверка на жизнеспособность юнита
     */
    public boolean isAlife() {
        for (int checkPartOfBody : curHealth) {
            if (checkPartOfBody <= 0) {
                return false;
            }
        }
        return true;
    }

}
