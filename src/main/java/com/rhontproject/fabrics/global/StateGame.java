package com.rhontproject.fabrics.global;

import org.springframework.stereotype.Component;

/**
 * Глобальные флаги необходимые для работы событий. /магазин/привал/крафт/повышения уровня/воровство
 * isRob - событие для этого флага пока нет. Игра не доведена до логического финала.
 */
@Component
public final class StateGame {
    private StateGame() {
    }
    private static boolean marketExit = false;
    private static boolean halt = false;
    private static boolean craftIntoHalt = false;
    private static boolean levelUp = false;
    private static boolean isRob = false;

    public static synchronized boolean isMarketExit() {
        return marketExit;
    }

    public static synchronized void setMarketExit(boolean marketExit) {
        StateGame.marketExit = marketExit;
    }

    public static synchronized boolean isHalt() {
        return halt;
    }

    public static synchronized void setHalt(boolean halt) {
        StateGame.halt = halt;
    }

    public static synchronized boolean isCraftIntoHalt() {
        return craftIntoHalt;
    }

    public static synchronized void setCraftIntoHalt(boolean craftIntoHalt) {
        StateGame.craftIntoHalt = craftIntoHalt;
    }

    public static synchronized boolean isLevelUp() {
        return levelUp;
    }

    public static synchronized void setLevelUp(boolean levelUp) {
        StateGame.levelUp = levelUp;
    }

    public static synchronized boolean isIsRob() {
        return isRob;
    }

    public static synchronized void setIsRob(boolean isRob) {
        StateGame.isRob = isRob;
    }
}
