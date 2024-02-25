package com.rhontproject.acts.actsaction;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.acts.Act;
import com.rhontproject.enums.MarketEnum;

import java.util.Scanner;

import static java.lang.System.*;

public final class Market extends Act {
    @Override
    public void run() {
        knight.print_inv_and_money();
        market_place(knight, stateGame);
    }

    private void market_place(Unit knight, StateGame stateGame) {
        out.println("Вас встречает трактирщик. На его прилавке скучают вещи, вы внимательно смотрите на них.");
        out.println(MarketEnum.SHIELD.getItemNumber() + " Щит | Цена: " + MarketEnum.SHIELD.getCost());
        out.println(MarketEnum.POTION_OF_HEALTH.getItemNumber() + " Зелье здоровья | Цена: " + MarketEnum.POTION_OF_HEALTH.getCost());
        out.println(MarketEnum.MOLOTOV.getItemNumber() + " Коктейль молотова | Цена: " + MarketEnum.MOLOTOV.getCost());
        out.println("0 Выход из трактира");

        while (!stateGame.market_exit) {
            String for_market_scanner;
            Scanner scan_market = new Scanner(in);
            for_market_scanner = scan_market.nextLine();
            switch (for_market_scanner) {
                case ("1"):
                    if (MarketEnum.SHIELD.getCost() <= knight.money) {
                        knight.money -= MarketEnum.SHIELD.getCost();
                        knight.param_inventory[1] += 2;
                        out.println("Вы купили щит!");
                        break;
                    } else {
                        out.println("Невозможно купить щит. Вам не хватает " + (MarketEnum.SHIELD.getCost() - knight.money));
                        break;
                    }
                case ("2"):
                    if (MarketEnum.POTION_OF_HEALTH.getCost() <= knight.money) {
                        knight.money -= MarketEnum.POTION_OF_HEALTH.getCost();
                        knight.param_inventory[3] += 1;
                        out.println("Вы купили зелье!");
                        break;
                    } else {
                        out.println("Невозможно купить зелье. Вам не хватает " + (MarketEnum.POTION_OF_HEALTH.getCost() - knight.money));
                        break;
                    }

                case ("3"):
                    if (MarketEnum.MOLOTOV.getCost() <= knight.money) {
                        knight.money -= MarketEnum.MOLOTOV.getCost();
                        knight.param_inventory[2] += 1;
                        out.println("Вы купили молотов");
                        break;
                    } else {
                        out.println("Невозможно купить коктейль молотова. Вам не хватает " + (MarketEnum.MOLOTOV.getCost() - knight.money));
                        break;
                    }

                case ("0"): {
                    stateGame.market_exit = true;
                    break;
                }

                default:
                    out.println("Значение введено неправильно");
            }
        }
        stateGame.market_exit = false;
    }
}
