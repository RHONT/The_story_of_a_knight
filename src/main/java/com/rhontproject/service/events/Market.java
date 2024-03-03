package com.rhontproject.service.events;

import com.rhontproject.service.MessageService;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.inventory.InventoryEnum;
import com.rhontproject.unit.defense.HardShield;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrics.global.StateGame.*;
import static java.lang.System.in;
import static java.lang.System.out;

@Component
public class Market {
    @Autowired
    private MessageService messageService;

    public void marketPlace(Unit knight) {
        final String buyShield = "1";
        final String buyPotion = "2";
        final String buyMolotov = "3";
        final String exit = "0";
        messageService.printInventory(knight);
        out.println("Вас встречает трактирщик. На его прилавке скучают вещи, вы внимательно смотрите на них.");
        out.println(MarketEnum.SHIELD.getItemNumber() + " Щит | Цена: " + MarketEnum.SHIELD.getCost());
        out.println(MarketEnum.POTION_OF_HEALTH.getItemNumber() + " Зелье здоровья | Цена: " + MarketEnum.POTION_OF_HEALTH.getCost());
        out.println(MarketEnum.MOLOTOV.getItemNumber() + " Коктейль молотова | Цена: " + MarketEnum.MOLOTOV.getCost());
        out.println("0 Выход из трактира");

        while (!isMarketExit()) {
            String marketStr;
            Scanner scanMarket = new Scanner(in);
            marketStr = scanMarket.nextLine();
            switch (marketStr) {
                case buyShield:
                    if (MarketEnum.SHIELD.getCost() <= knight.getMoney()) {
                        knight.minusMoney(MarketEnum.SHIELD.getCost());
                        knight.getDefenseWall().add(new HardShield(), 1);
                        out.println("Вы купили щит!");
                    } else {
                        out.println("Невозможно купить щит. Вам не хватает " + (MarketEnum.SHIELD.getCost() - knight.getMoney()));
                    }
                    break;
                case buyPotion:
                    if (MarketEnum.POTION_OF_HEALTH.getCost() <= knight.getMoney()) {
                        knight.minusMoney(MarketEnum.POTION_OF_HEALTH.getCost());
                        knight.getInventorySet().add(InventoryEnum.POTION, 1);
                        out.println("Вы купили зелье!");
                    } else {
                        out.println("Невозможно купить зелье. Вам не хватает " + (MarketEnum.POTION_OF_HEALTH.getCost() - knight.getMoney()));
                    }
                    break;

                case buyMolotov:
                    if (MarketEnum.MOLOTOV.getCost() <= knight.getMoney()) {
                        knight.minusMoney(MarketEnum.MOLOTOV.getCost());
                        knight.getInventorySet().add(InventoryEnum.MOLOTOV, 1);
                        out.println("Вы купили молотов");
                    } else {
                        out.println("Невозможно купить коктейль молотова. Вам не хватает " + (MarketEnum.MOLOTOV.getCost() - knight.getMoney()));
                    }
                    break;

                case exit: {
                    setMarketExit(true);
                    break;
                }

                default:
                    out.println("Значение введено неправильно");
            }
        }
        setMarketExit(false);
    }
}
