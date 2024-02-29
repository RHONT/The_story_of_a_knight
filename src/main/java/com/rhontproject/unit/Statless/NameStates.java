package com.rhontproject.unit.Statless;

import com.rhontproject.unit.Statless.negative.Burning;
import com.rhontproject.unit.Statless.negative.Posion;
import com.rhontproject.unit.Statless.positive.Regenerate;

public enum NameStates {
    BURN(Burning.class.getSimpleName()),
    POSION(Posion.class.getSimpleName()),
    REGENERATE(Regenerate.class.getSimpleName());

    private final String nameClass;

    NameStates(String nameState) {
        this.nameClass=nameState;
    }

    public String getNameClass() {
        return nameClass;
    }
}
