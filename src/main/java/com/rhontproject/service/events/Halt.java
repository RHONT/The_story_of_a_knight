package com.rhontproject.service.events;

import com.rhontproject.fabrics.global.StateGame;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.inventory.InventoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static java.lang.System.in;
import static java.lang.System.out;

@Component
public class Halt {
    /**
     * метод реализующий привал/отдых, когда персонаж подготавливаеться к следующему вызову
     */
    public void halt(Unit unit) {
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
        while (!StateGame.isHalt()) {
            switch_for_halt(unit);
        }
        StateGame.setHalt(false);
        StateGame.setCraftIntoHalt(false);
        out.println("Вы продолжили путешествие.");
        out.println();
    }


    /**
     * вспомогательный метод реализующий функционал метода halt()
     */
    private void switch_for_halt(Unit unit) {
        Scanner scan_halt = new Scanner(in);
        String buf_str = scan_halt.nextLine();
        switch (buf_str) {
            case "1":
                if (unit.getInventorySet().get(InventoryEnum.POTION) > 0) {
                    for (int i = 0; i < 4; i++) {
                        unit.attribute.curHealth[i] += 70;
                    }
                    unit.getInventorySet().use(InventoryEnum.POTION);
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
                if (unit.getDefenseWall().getDurability() == 0) {

                    if (unit.getDefenseWall().loadShield()) {
                        out.println("Вы приготовили щит к следующему бою");
                        break;
                    } else {
                        out.println("У вас нет щитов");
                        break;
                    }
                } else {
                    out.println("Ваш щит уже приготовлен, его прочность: " + unit.getDefenseWall().getDurability());
                    break;
                }

            case "3":
                if (StateGame.isCraftIntoHalt())
                    out.println("На привале можно починить лишь один элемент брони. Вы уже этим воспользовались");
                LABEL_1:
                while (!StateGame.isCraftIntoHalt()) {
                    out.println("Что будем чинить? 1-2-3-4? Прочность элемента повышаеться на 30");
                    Scanner str_craft = new Scanner(in);
                    String strCraftArmor = str_craft.nextLine();
                    switch (strCraftArmor) {
                        case "1":
                        case "2":
                        case "3":
                        case "4": {
                            int curIndexArmor=Integer.parseInt(strCraftArmor)-1;
                            unit.attribute.defense[curIndexArmor] += 30;
                            StateGame.setCraftIntoHalt(true);
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
                StateGame.setHalt(true);
                break;
            }

            default:
                out.println("Введено недопустимое значение");
        }
    }
}
