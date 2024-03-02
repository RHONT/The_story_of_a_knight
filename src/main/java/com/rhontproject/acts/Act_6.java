package com.rhontproject.acts;

import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.UnitFabric.createOutLowBridge;
import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.service.SystemUtility.*;
import static java.lang.System.*;
@Component
public class Act_6 extends Act {
    private String payOff ="Сэр Томас ощутил жжение в области своего достоинства. " +
            "вполне может быть, это было и верное решени...\nВаша уверенность упала(-7) и теперь ваша базовая" +
            "меткость составляет: ";
    private String moneyIsTaught="У вас не нашлось нужной суммы. Жулики забрали все что у вас есть, включая ваш инвентарь" +
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
                    if (knight.money > 400) {
                        knight.money -= 400;
                        knight.chance_to_attack -= 7;
                        out.println(payOff  + knight.chance_to_attack);

                    } else {
                        knight.chance_to_attack -= 15;
                        knight.money = 0;
                        //todo обнулить инвентарь
//                        Arrays.fill(knight.inventory,0);
                        out.println(moneyIsTaught  + knight.chance_to_attack);
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
