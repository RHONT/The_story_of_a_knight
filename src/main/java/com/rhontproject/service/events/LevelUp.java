package com.rhontproject.service.events;

import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static com.rhontproject.fabrics.global.StateGame.*;
import static java.lang.System.in;
import static java.lang.System.out;

@Component
public class LevelUp {
    /**
     * Повышения уровня персонажа
     */
    public void levelUp(Unit unit) {
        out.println();
        out.println("Сэр Томас отдышался. Оглядел поле боя и решил задуматься, точнее некоторые мысли " +
                "\nназойливые как комары заставляли его это сделать. Не в силах сражаться с самим собой он впустил к себе одну из них." +
                "\n1 - Как сильно бьется мое сердце, словно удары молота о наковальню. Мое тело идеальный механизм!" +
                "\n2 - А ведь не так быстро двигался враг, был момент даже когда мне показалось, что время замедлилось." +
                "\n3 - Я несколько иначе ощущал свой меч, словно он стал моим продолжением");
        while (!isLevelUp()) {
            switchLevelUp(unit);
        }
        setLevelUp(false);
        out.println();
    }

    /**
     * Вспомогательный метод для реализации метода level_up
     */

    private void switchLevelUp(Unit unit) {
        final String moreHealth="1";
        final String moreChanceAttack="2";
        final String moreDamage="3";
        Scanner scanLevelUp = new Scanner(in);
        String tempStr = scanLevelUp.nextLine();
        switch (tempStr) {
            case moreHealth:
                for (int i = 0; i < 4; i++) {
                    unit.attribute.curHealth[i] += 10;
                    unit.attribute.baseHealth[i] += 10;
                }
                out.println("Ваше здоровье увеличено на 10 единиц по каждому пункту.");
                messageService.printHealthDefense(unit);
                setLevelUp(true);
                break;
            case moreChanceAttack:
                unit.plusChanceAttack(5);
                out.println
                        ("Ваша базовая меткость увеличилась на 5 единиц, теперь она составляет:" +
                                unit.getChanceAttack());
                setLevelUp(true);
                break;
            case moreDamage:
                unit.getWeapon().upPower(7);
                out.println
                        ("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" +
                                unit.getWeapon().getPower());
                messageService.printHealthDefense(unit);
                setLevelUp(true);
                break;
            default:
                out.println("Сэр Томас немного отвлекся, но смог с легкостью сосредоточиться вновь.");
        }
    }
}
