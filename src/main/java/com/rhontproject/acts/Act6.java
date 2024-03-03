package com.rhontproject.acts;

import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.UnitFabric.createOutLowBridge;
import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.service.SystemUtility.*;
import static java.lang.System.*;
@Component
public class Act6 extends Act {
    private final String payOff ="Сэр Томас ощутил жжение в области своего достоинства. " +
            "вполне может быть, это было и верное решени...\nВаша уверенность упала(-7) и теперь ваша базовая" +
            "меткость составляет: ";
    private final String moneyIsTaught="У вас не нашлось нужной суммы. Жулики забрали все что у вас есть, включая ваш инвентарь" +
            "\nТак жалко сэр Томас себя еще никогда не ощущал. \nВаша уверенность упала(-15) и теперь ваша базовая" +
            "меткость составляет:  ";

    @Override
    public void run() {
        printFromFile("[2-1].txt");
        bridge(createOutLowBridge(), createOutLowBridge(), createOutLowBridge(), createOutLowBridge());
    }
    /**
     * метод запускающий события на мосту.
     */
    private void bridge(Unit... enemy) {
        while (true) {
            String eventOnBridge = scanner.nextLine();
            switch (eventOnBridge) {
                case ("2"):
                    if (knight.getMoney() > 400) {
                        knight.minusMoney(400);
                        knight.minusChanceAttack(7);
                        out.println(payOff  + knight.getChanceAttack());

                    } else {
                        knight.minusChanceAttack(15);
                        knight.setMoney(0);
                        knight.getInventorySet().clearInventory();
                        out.println(moneyIsTaught  + knight.getChanceAttack());
                        return;
                    }
                case ("1"):
                    eventKnightService.fightArea(enemy);
                    return;
                default:
                    out.println("Значение введено неправильно");
            }
        }
    }
}
