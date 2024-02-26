package com.rhontproject.newarchitecture.state;

import com.rhontproject.abstractUnitParent.Unit;

public interface StateAction {
    void activate();
    void disable();
    void action(Unit unit);

}
