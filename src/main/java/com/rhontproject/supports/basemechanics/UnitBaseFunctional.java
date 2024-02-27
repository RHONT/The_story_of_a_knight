package com.rhontproject.supports.basemechanics;

import com.rhontproject.abstractUnitParent.Unit;

public interface UnitBaseFunctional {
    void setUnit(Unit unit);

    void level_up();

    boolean isAlife();

    void stabilizeHealth();

    void reborn();

    void halt();

    void setHealth(int[] health);

}
