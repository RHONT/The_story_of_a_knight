package com.rhontproject.newarchitecture.state;

import com.rhontproject.newarchitecture.state.negative.Burning;
import com.rhontproject.newarchitecture.state.positive.Regenerate;

public enum NameStates {
    BURN(Burning.class.getSimpleName()),POSION("Posion"),REGENERATE(Regenerate.class.getSimpleName());

    private final String nameClass;

    NameStates(String nameState) {
        this.nameClass=nameState;
    }

    public String getNameClass() {
        return nameClass;
    }
}
