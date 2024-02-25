package com.rhontproject.supports;

import com.rhontproject.abstractUnitParent.Unit;

public interface UnitSupportFunctional {
    void setUnit(Unit unit);

    void level_up();

    boolean isAlife();

    void printHealthDefense();

    void stabilizeHealth();

    void reborn();

    void printDefense();

    void printInventory();

    void printInfoFight();

    void halt();

    void setParam_humanoid(int[] param_humanoid);

}
