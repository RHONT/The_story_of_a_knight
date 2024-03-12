package com.rhontproject.unit.attack;

import com.rhontproject.unit.Unit;

/**
 * Атака по противнику. Каждый класс который его реализует, сам будет определять правила атаки соперника
 */
public interface DuelScenario {
    void attacking(Unit attacking, Unit victim);
}
