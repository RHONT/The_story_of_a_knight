package com.rhontproject.service;

import com.rhontproject.fabrics.global.StateGame;
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
    private final Market market;
    private final FightArea fightArea;


    public EventKnightService(LevelUp levelUp, Halt halt, Market market, FightArea fightArea) {
        this.levelUp = levelUp;
        this.halt = halt;
        this.market = market;
        this.fightArea = fightArea;
    }

    public void levelUp() {
        levelUp.level_up(knight);
    }

    public void halt() {
        halt.halt(knight);
    }

    public void market() {
        market.marketPlace(knight);
    }

    public void fightArea(Unit... enemy) {
        fightArea.fight(knight, enemy);
    }


}
