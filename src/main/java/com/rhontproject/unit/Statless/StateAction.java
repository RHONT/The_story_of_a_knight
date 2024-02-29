package com.rhontproject.unit.Statless;

import com.rhontproject.unit.Unit;

public interface StateAction {
    void activate();
    void disable();
    void action(Unit unit);

}
