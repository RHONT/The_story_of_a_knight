package com.rhontproject.acts.actsaction;

public final class StateGame {
    public boolean market_exit = false;                 // 0 - do in market, 1 - not do in market
    public boolean halt_param = false;                // Переключатель для привала(замыкает while)
    public boolean halt_craft = false;                // переключатель для крафта брони.
    public boolean level_up_param = false;
    public boolean isRob = false;// Переключатель повышения уровня(замыкает while)
}
