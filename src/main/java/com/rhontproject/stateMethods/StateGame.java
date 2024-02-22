package com.rhontproject.stateMethods;
/**
 * Состояние игры
 */
public final class StateGame {
    public boolean market_exit = false;                 // 0 - do in market, 1 - not do in market
    public boolean event_on_bridge = false;           // переключаитаель события на мосту.
    public boolean halt_param = false;                // Переключатель для привала(замыкает while)
    public boolean halt_craft = false;                // переключатель для крафта брони.
    public boolean level_up_param = false;
    public boolean thief_1 = false;// Переключатель повышения уровня(замыкает while)
}
