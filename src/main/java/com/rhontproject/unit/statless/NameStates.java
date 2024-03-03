package com.rhontproject.unit.statless;

import com.rhontproject.unit.statless.negative.Burning;
import com.rhontproject.unit.statless.negative.Poison;
import com.rhontproject.unit.statless.positive.Regenerate;

public enum NameStates {
    BURN(Burning.class.getSimpleName()),
    POISON(Poison.class.getSimpleName()),
    REGENERATE(Regenerate.class.getSimpleName());

    private final String nameClass;

    NameStates(String nameState) {
        this.nameClass=nameState;
    }

    public String getNameClass() {
        return nameClass;
    }
}
