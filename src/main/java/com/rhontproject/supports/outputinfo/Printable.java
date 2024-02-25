package com.rhontproject.supports.outputinfo;

import com.rhontproject.abstractUnitParent.Unit;

public interface Printable {

    void setUnit(Unit unit);

    void printDefense();

    void printInventory();

    void printInfoFight();

    void printHealthDefense();
}
