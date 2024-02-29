package com.rhontproject.service;

import com.rhontproject.acts.Act;
import com.rhontproject.unit.Unit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrics.GlobalVariable.messageService;
import static java.lang.System.in;
import static java.lang.System.out;

@Component
public class EventKnightService {
    private Unit unit;

    public EventKnightService(@Qualifier("Knight") Unit unit) {
        this.unit = unit;
    }
    /**
     * метод реализующий привал/отдых, когда персонаж подготавливаеться к следующему вызову
     */

    public void halt() {
        out.println();
        out.println("После битвы вы решили устроить короткий привал");
        messageService.printHealthDefense(unit);
        messageService.printInventory(unit);
        out.println();
        out.println("Что будете делать?\n" +
                "1 - Выпить зелье\n" +
                "2 - Приготовить щит\n" +
                "3 - Отремонтировать на выбор один элемент брони\n" +
                "0 - Продолжить путешествие\n");
        while (!Act.stateGame.halt_param) {
            switch_for_halt();
        }
        Act.stateGame.halt_param = false;
        Act.stateGame.halt_craft = false;
        out.println("Вы продолжили путешествие.");
        out.println();
    }

    /**
     * Повышения уровня юнита
     */

    public void level_up() {
        out.println();
        out.println("Сэр Томас отдышался. Оглядел поле боя и решил задуматься, точнее некоторые мысли " +
                "\nназойливые как комары заставляли его это сделать. Не в силах сражаться с самим собой он впустил к себе одну из них." +
                "\n1 - Как сильно бьеться мое сердце, словно удары молота о наковальню. Мое тело идеальный механизм!" +
                "\n2 - А ведь не так быстро двигался враг, был момент даже когда мне показалось, что время замедлилось." +
                "\n3 - Я несколько иначе ощущал свой меч, словно он стал моим продолжением");
        while (!Act.stateGame.level_up_param) {
            switch_for_level_up();
        }
        Act.stateGame.level_up_param = false;
        out.println();
    }

    /**
     * Вспомогательный метод для реализации метода level_up
     */

    private void switch_for_level_up() {
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
                Act.stateGame.level_up_param = true;
                break;
            case "2":
                unit.chance_to_attack += 5;
                out.println
                        ("Ваша базовая меткость увеличилась на 5 едениц, теперь она состовляет:" +
                                unit.chance_to_attack);
                Act.stateGame.level_up_param = true;
                break;
            case "3":
                unit.attribute.curHealth[4] += 7;
                unit.attribute.baseHealth[4] += 7;
                out.println
                        ("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" +
                                unit.attribute.curHealth[4]);
                messageService.printHealthDefense(unit);
                Act.stateGame.level_up_param = true;
                break;
            default:
                out.println("Сэр Томас немного отвлекся, но смог с легкостью сосредоточиться вновь.");
        }
    }

    /**
     * вспомогательный метод реализующий функционал метода halt()
     */
    private void switch_for_halt() {
        Scanner scan_halt = new Scanner(in);
        String buf_str = scan_halt.nextLine();
        switch (buf_str) {
            case "1":
                if (unit.inventory[3] > 0) {
                    for (int i = 0; i < unit.inventory.length; i++) {
                        unit.attribute.curHealth[i] += 70;
                    }
                    unit.inventory[3] -= 1;
                    out.println("Вы выпили зелье! Теперь ваше здовровье");
                    unit.stabilizeHealth();
                    messageService.printHealthDefense(unit);
                    out.println("Что еще хотите сделать?");
                    break;
                } else {
                    out.println("У вас нет зелья!");
                    break;
                }

            case "2":
                if (unit.inventory[0] == 0) {

                    if (unit.inventory[1] >= 2) {
                        unit.inventory[0] += 2;
                        unit.inventory[1] -= 2;
                        out.println("Вы приготовили щит к следующему бою");
                        break;
                    } else {
                        out.println("У вас нет щитов");
                        break;
                    }
                } else {
                    out.println("Ваш щит уже приготовлен, его прочность: " + unit.inventory[0]);
                    break;
                }

            case "3":
                if (Act.stateGame.halt_craft)
                    out.println("На привале можно починить лишь один элемент брони. Вы уже этим воспользовались");
                LABEL_1:
                while (!Act.stateGame.halt_craft) {
                    out.println("Что будем чинить? 1-2-3-4? Прочность элемента повышаеться на 30");
                    Scanner str_craft = new Scanner(in);
                    String buf_str_for_craft = str_craft.nextLine();
                    switch (buf_str_for_craft) {
                        case "1": {
                            unit.attribute.defense[0] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            break;
                        }
                        case "2": {
                            unit.attribute.defense[1] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            break;
                        }
                        case "3": {
                            unit.attribute.defense[2] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            break;
                        }
                        case "4": {
                            unit.attribute.defense[3] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            break;
                        }
                        default:
                            out.println("Введено недопустимое значение");
                            out.println();
                            continue LABEL_1;
                    }
                    messageService.printDefense(unit);
                    break;
                }
                break;

            case "0": {
                Act.stateGame.halt_param = true;
                break;
            }

            default:
                out.println("Введено недопустимое значение");
        }
    }

}
