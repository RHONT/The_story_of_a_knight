package com.rhontproject.abstractUnitParent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope("prototype")
public class BaseAttribute {
    public int[] curHealth = {1, 1, 1, 1, 1};
    public int[] curDefense = {0, 0, 0, 0};
    public int[] baseHealth;
    public int[] baseDefense = Arrays.copyOfRange(curDefense, 0, curDefense.length);

    public void setCurHealth(int[] curHealth) {
        this.curHealth = curHealth;
        this.baseHealth = Arrays.copyOfRange(curHealth, 0, curHealth.length);
    }

    public void setCurDefense(int[] curDefense) {
        this.curDefense = curDefense;
        this.baseDefense = Arrays.copyOfRange(curDefense, 0, curDefense.length);
    }

    public void setDefense(int helm, int tors, int hand, int leg) {
        this.curDefense = new int[]{helm, tors, hand, leg};
        this.baseDefense = Arrays.copyOfRange(curDefense, 0, curDefense.length);
    }
}
