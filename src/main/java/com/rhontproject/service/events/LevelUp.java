package com.rhontproject.service.events;

import com.rhontproject.fabrics.global.StateGame;
import com.rhontproject.unit.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static java.lang.System.in;
import static java.lang.System.out;

@Component
public class LevelUp {
    @Autowired
    private StateGame stateGame;

    /**
     * Повышения уровня юнита
     */
    public void level_up(Unit unit) {
        out.println();
        out.println("Сэр Томас отдышался. Оглядел поле боя и решил задуматься, точнее некоторые мысли " +
                "\nназойливые как комары заставляли его это сделать. Не в силах сражаться с самим собой он впустил к себе одну из них." +
                "\n1 - Как сильно бьеться мое сердце, словно удары молота о наковальню. Мое тело идеальный механизм!" +
                "\n2 - А ведь не так быстро двигался враг, был момент даже когда мне показалось, что время замедлилось." +
                "\n3 - Я несколько иначе ощущал свой меч, словно он стал моим продолжением");
        while (!stateGame.level_up_param) {
            switch_for_level_up(unit);
        }
        stateGame.level_up_param = false;
        out.println();
    }

    /**
     * Вспомогательный метод для реализации метода level_up
     */

    private void switch_for_level_up(Unit unit) {
        Scanner scan_level_up = new Scanner(in);
        String buf_str = scan_level_up.nextLine();
        switch (buf_str) {
            case "1":
                for (int i = 0; i < 4; i++) {
                    unit.attribute.curHealth[i] += 10;
                    unit.attribute.baseHealth[i] += 10;
                }
                out.println("Ваше здоровье увеличено на 10 едениц по каждому пунку.");
                messageService.printHealthDefense(unit);
                stateGame.level_up_param = true;
                break;
            case "2":
                unit.chance_to_attack += 5;
                out.println
                        ("Ваша базовая меткость увеличилась на 5 едениц, теперь она состовляет:" +
                                unit.chance_to_attack);
                stateGame.level_up_param = true;
                break;
            case "3":
                unit.getWeapon().upPower(7);
                out.println
                        ("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" +
                                unit.getWeapon().getPower());
                messageService.printHealthDefense(unit);
                stateGame.level_up_param = true;
                break;
            default:
                out.println("Сэр Томас немного отвлекся, но смог с легкостью сосредоточиться вновь.");
        }
    }
}
