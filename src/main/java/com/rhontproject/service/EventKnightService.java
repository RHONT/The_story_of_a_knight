package com.rhontproject.service;

import com.rhontproject.service.events.FightArea;
import com.rhontproject.service.events.Halt;
import com.rhontproject.service.events.LevelUp;
import com.rhontproject.service.events.Market;
import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;

@Component
public class EventKnightService {
    private final LevelUp levelUp;
    private final Halt halt;
    private final FightArea fightArea;
    private final Market market;


    public EventKnightService(LevelUp levelUp, Halt halt, Market market, FightArea fightArea) {
        this.levelUp = levelUp;
        this.halt = halt;
        this.fightArea = fightArea;
        this.market = market;
    }

    public void levelUp() {
        levelUp.levelUp(knight);
    }

    public void halt() {
        halt.halt(knight);
    }

    public void market() {
        market.run();
    }

    public void fightArea(Unit... enemy) {
        fightArea.fight(knight, enemy);
    }
}
