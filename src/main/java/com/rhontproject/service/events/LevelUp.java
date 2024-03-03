package com.rhontproject.service.events;

import com.rhontproject.fabrics.global.StateGame;
import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static java.lang.System.in;
import static java.lang.System.out;

@Component
public class LevelUp {
    /**
     * Повышения уровня юнита
     */
    public void levelUp(Unit unit) {
        out.println();
        out.println("Сэр Томас отдышался. Оглядел поле боя и решил задуматься, точнее некоторые мысли " +
                "\nназойливые как комары заставляли его это сделать. Не в силах сражаться с самим собой он впустил к себе одну из них." +
                "\n1 - Как сильно бьеться мое сердце, словно удары молота о наковальню. Мое тело идеальный механизм!" +
                "\n2 - А ведь не так быстро двигался враг, был момент даже когда мне показалось, что время замедлилось." +
                "\n3 - Я несколько иначе ощущал свой меч, словно он стал моим продолжением");
        while (!StateGame.isLevelUp()) {
            switchLevelUp(unit);
        }
        StateGame.setLevelUp(false);
        out.println();
    }

    /**
     * Вспомогательный метод для реализации метода level_up
     */

    private void switchLevelUp(Unit unit) {
        Scanner scanLevelUp = new Scanner(in);
        String tempStr = scanLevelUp.nextLine();
        switch (tempStr) {
            case "1":
                for (int i = 0; i < 4; i++) {
                    unit.attribute.curHealth[i] += 10;
                    unit.attribute.baseHealth[i] += 10;
                }
                out.println("Ваше здоровье увеличено на 10 едениц по каждому пунку.");
                messageService.printHealthDefense(unit);
                StateGame.setLevelUp(true);
                break;
            case "2":
                unit.chanceAttack += 5;
                out.println
                        ("Ваша базовая меткость увеличилась на 5 едениц, теперь она состовляет:" +
                                unit.chanceAttack);
                StateGame.setLevelUp(true);
                break;
            case "3":
                unit.getWeapon().upPower(7);
                out.println
                        ("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" +
                                unit.getWeapon().getPower());
                messageService.printHealthDefense(unit);
                StateGame.setLevelUp(true);
                break;
            default:
                out.println("Сэр Томас немного отвлекся, но смог с легкостью сосредоточиться вновь.");
        }
    }
}
