package com.rhontproject.acts;

import com.rhontproject.abstractUnitParent.Humanoid;

import java.util.Arrays;
import java.util.Scanner;

import static com.rhontproject.fabrica.UnitFabric.createOutLowBridge;
import static com.rhontproject.stateMethods.Utility.*;

public class Act_6 extends Act {
    @Override
    public void run() {
        printFromFile("[2-1].txt");
        bridge(createOutLowBridge(), createOutLowBridge(), createOutLowBridge(), createOutLowBridge());
        System.out.println(Arrays.toString(knight.param_inventory));
    }
    /**
     * метод запускающий события на мосту.
     */
    private void bridge(Humanoid... enemy) {
        while (!stateGame.event_on_bridge) {
            String for_market_scanner;
            Scanner scan_market = new Scanner(System.in);
            for_market_scanner = scan_market.nextLine();
            switch (for_market_scanner) {
                case ("2"):
                    if (knight.money > 400) {
                        knight.money -= 400;

                        knight.chance_to_attack -= 7;
                        System.out.println("Сэр Томас ощутил жжение в области своего достоинства. " +
                                "вполне может быть, это было и верное решени...\nВаша уверенность упала(-7) и теперь ваша базовая" +
                                "меткость составляет: " + knight.chance_to_attack);

                        stateGame.event_on_bridge = true;

                        break;
                    } else {
                        knight.chance_to_attack -= 15;
                        System.out.println("У вас не нашлось нужной суммы. Жулики забрали все что у вас есть, включая ваш инвентарь" +
                                "\nТак жалко сэр Томас себя еще никогда не ощущал. \nВаша уверенность упала(-15) и теперь ваша базовая" +
                                "меткость составляет:  " + knight.chance_to_attack);
                        knight.param_inventory = Arrays.stream(knight.param_inventory).map(e -> {
                            e = 0;
                            return e;
                        }).toArray();
                        knight.money = 0;
                        stateGame.event_on_bridge = true;
                        break;
                    }
                case ("1"):
                    fight(knight, enemy);
                    stateGame.event_on_bridge = true;
                    break;
                default:
                    System.out.println("Значение введено неправильно");
            }
        }
        stateGame.event_on_bridge = false;
    }
}
