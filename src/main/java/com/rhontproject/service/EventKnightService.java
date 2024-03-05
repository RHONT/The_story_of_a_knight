package com.rhontproject.service;

import com.rhontproject.service.events.FightArea;
import com.rhontproject.service.events.Halt;
import com.rhontproject.service.events.Market;
import com.rhontproject.service.events.LevelUp;
import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;

/**
 * Класс для запуска событий игры
 * Магазин/повышение уровня/привал/битва
 */

@Component
public class EventKnightService {
    private final LevelUp levelUp;
    private final Halt halt;
    private final FightArea fightArea;
    private final Market market;


    public EventKnightService(LevelUp levelUp, Halt halt, Market market, FightArea fightArea) {
        this.halt = halt;
        this.fightArea = fightArea;
        this.market = market;
        this.levelUp = levelUp;
    }

    public void levelUp() {
        levelUp.run();
    }

    public void halt() {
        halt.halt();
    }

    public void market() {
        market.run();
    }

    public void fightArea(Unit... enemy) {
        fightArea.fight(knight, enemy);
    }
}
