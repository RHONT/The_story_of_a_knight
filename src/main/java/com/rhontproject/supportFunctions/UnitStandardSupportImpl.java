package com.rhontproject.supportFunctions;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.acts.Act;
import com.rhontproject.interfaceSupporFunctionHumanoid.UnitSupportFunctional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;


@Component
@Scope("prototype")
public class UnitStandardSupportImpl implements UnitSupportFunctional {
    Unit unit;

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * метод реализующий привал/отдых, когда персонаж подготавливаеться к следующему вызову
     */

    public void halt() {
        out.println();
        out.println("После битвы вы решили устроить короткий привал");
        print_health_info();
        print_inv_and_money();
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

    @Override
    public void setParam_humanoid(int[] param_humanoid) {

    }

    /**
     * вспомогательный метод реализующий функционал метода halt()
     */

    public void switch_for_halt() {
        Scanner scan_halt = new Scanner(in);
        String buf_str = scan_halt.nextLine();
        switch (buf_str) {
            case "1":
                if (unit.param_inventory[3] > 0) {
                    for (int i = 0; i < unit.param_inventory.length; i++) {
                        unit.param_humanoid[i] += 70;
                    }
                    unit.param_inventory[3] -= 1;
                    out.println("Вы выпили зелье! Теперь ваше здовровье");
                    stabilizeHealth();
                    print_health_info();
                    out.println("Что еще хотите сделать?");
                    break;
                } else {
                    out.println("У вас нет зелья!");
                    break;
                }

            case "2":
                if (unit.param_inventory[0] == 0) {

                    if (unit.param_inventory[1] >= 2) {
                        unit.param_inventory[0] += 2;
                        unit.param_inventory[1] -= 2;
                        out.println("Вы приготовили щит к следующему бою");
                        break;
                    } else {
                        out.println("У вас нет щитов");
                        break;
                    }
                } else {
                    out.println("Ваш щит уже приготовлен, его прочность: " + unit.param_inventory[0]);
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
                            unit.defense[0] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        case "2": {
                            unit.defense[1] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        case "3": {
                            unit.defense[2] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        case "4": {
                            unit.defense[3] += 30;
                            Act.stateGame.halt_craft = true;
                            out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        default:
                            out.println("Введено недопустимое значение");
                            out.println();
                            continue LABEL_1;
                    }
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

    /**
     * Вывод на экран накопительной строки info_str_figth
     * в используемых методах она перезаписываеться, после того как выдала актуальную информацию
     */

    public void print_info_fight() {
        out.println(unit.info_str_fight);
        unit.info_str_fight = "";
    }

    public void print_inv_and_money() {
        String sb = "\n" +
                "Золота у вас: " + unit.money + "\n" +
                "Прочность щита в руке: " + unit.param_inventory[0] + "\n" +
                "Количество щитов: " + unit.param_inventory[1] + "\n" +
                "Коктейля молотова: " + unit.param_inventory[2] + "\n" +
                "Целебного зелья: " + unit.param_inventory[3] + "\n";
        out.println(sb);
    }

    public void print_defense() {
        out.println("Состояние брони:\n" +
                "Шлем: " + unit.defense[0] +
                " Нагрудник: " + unit.defense[1] +
                " Нарукавники: " + unit.defense[2] +
                " Поножи: " + unit.defense[3]);
    }

    /**
     * Воскрешение юнита
     * Чтобы была возможность использовать его вновь, не создавая еще один экземпляр
     */
    public void reborn() {
        unit.param_humanoid = Arrays.copyOfRange(unit.copy_param_humanoid, 0, 5);
        unit.defense = Arrays.copyOfRange(unit.copy_param_defense, 0, unit.copy_param_defense.length);
        unit.i_am_fire = false;
        unit.chance_to_attack = 80;
    }

    /**
     * Когда выпиваеться зелье здоровья, то показатели выходят за пределы
     * После боя завышенные показатели должны приходить в норму
     */

    public void stabilizeHealth() {
        for (int i = 0; i < 4; i++) {
            if (unit.copy_param_humanoid[i] < unit.param_humanoid[i]) {
                unit.param_humanoid[i] = unit.copy_param_humanoid[i];
            }
        }
    }

    /**
     * Выводит информацию о состоянии здоровья и брони
     */

    public void print_health_info() {
        String info_str;
        String spec_char = "";

        info_str = ("Голова: " + unit.param_humanoid[0] + "/" + unit.copy_param_humanoid[0] + " [" + unit.defense[0] + "]" +
                " Тело: " + unit.param_humanoid[1] + "/" + unit.copy_param_humanoid[1] + " [" + unit.defense[1] + "]" +
                " Руки: " + unit.param_humanoid[2] + "/" + unit.copy_param_humanoid[2] + " [" + unit.defense[2] + "]" +
                " Ноги: " + unit.param_humanoid[3] + "/" + unit.copy_param_humanoid[3] + " [" + unit.defense[3] + "]" +
                " Сила оружия: " + unit.param_humanoid[4]);
        for (int i = 0; i < info_str.length(); i++) {
            spec_char += "-";
        }

        out.println(spec_char);
        out.println(unit.name);
        out.println(info_str);
    }

    /**
     * Проверка на жизнеспособность юнита
     */

    public boolean isAlife() {
        boolean life = false;
        for (int checkPartOfBody : unit.param_humanoid) {
            if (checkPartOfBody <= 0) {
                life = false;
                break;
            } else life = true;
        }
        return life;
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

    public void switch_for_level_up() {
        Scanner scan_level_up = new Scanner(in);
        String buf_str = scan_level_up.nextLine();
        switch (buf_str) {
            case "1":
                for (int i = 0; i < 4; i++) {
                    unit.param_humanoid[i] += 10;
                    unit.copy_param_humanoid[i] += 10;
                }
                out.println("Ваше здоровье увеличено на 10 едениц по каждому пунку.");
                print_health_info();
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
                unit.param_humanoid[4] += 7;
                unit.copy_param_humanoid[4] += 7;
                out.println
                        ("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" +
                                unit.param_humanoid[4]);
                print_health_info();
                Act.stateGame.level_up_param = true;
                break;
            default:
                out.println("Сэр Томас немного отвлекся, но смог с легкостью сосредоточиться вновь.");
        }

    }
}
