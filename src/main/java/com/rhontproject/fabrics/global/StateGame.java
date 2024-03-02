package com.rhontproject.fabrics.global;

import org.springframework.stereotype.Component;

@Component
public final class StateGame {
    public static boolean market_exit = false;                 // 0 - do in market, 1 - not do in market
    public static boolean halt_param = false;                // Переключатель для привала(замыкает while)
    public static boolean halt_craft = false;                // переключатель для крафта брони.
    public static boolean level_up_param = false;
    public static boolean isRob = false;// Переключатель повышения уровня(замыкает while)
}
