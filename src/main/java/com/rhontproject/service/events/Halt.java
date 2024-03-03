package com.rhontproject.service.events;

import com.rhontproject.fabrics.global.StateGame;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.inventory.InventoryEnum;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static java.lang.System.in;
import static java.lang.System.out;
/**
 * метод реализующий привал/отдых, когда персонаж подготавливается к следующему вызову
 */
@Component
public class Halt {

    public void halt(Unit unit) {
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
            switchHalt();
        }
        StateGame.setHalt(false);
        StateGame.setCraftIntoHalt(false);
        out.println("Вы продолжили путешествие.");
        out.println();
    }

    /**
     * вспомогательный метод реализующий функционал метода halt()
     */
    private void switchHalt() {
        final String drinkPotion = "1";
        final String prepareTheShield = "2";
        final String repair = "3";
        final String exit = "0";
        Scanner scanHalt = new Scanner(in);
        String tempStr = scanHalt.nextLine();
        switch (tempStr) {
            case drinkPotion:
                if (knight.getInventorySet().get(InventoryEnum.POTION) > 0) {
                    drinkingPotion();
                } else {
                    out.println("У вас нет зелья!");
                }
                break;
            case prepareTheShield:
                if (knight.getDefenseWall().getDurability() == 0) {
                    if (knight.getDefenseWall().loadShield()) {
                        out.println("Вы приготовили щит к следующему бою");
                    } else {
                        out.println("У вас нет щитов");
                    }
                } else {
                    out.println("Ваш щит уже приготовлен, его прочность: " + knight.getDefenseWall().getDurability());
                }
                break;

            case repair:
                if (StateGame.isCraftIntoHalt()) {
                    out.println("На привале можно починить лишь один элемент брони. Вы уже этим воспользовались");
                } else {
                    repairArmor();
                }
                break;
            case exit: {
                StateGame.setHalt(true);
                break;
            }
            default:
                out.println("Введено недопустимое значение");
        }
    }

    private void drinkingPotion() {
        for (int i = 0; i < 4; i++) {
            knight.attribute.curHealth[i] += 70;
        }
        knight.getInventorySet().use(InventoryEnum.POTION);
        out.println("Вы выпили зелье! Теперь ваше здоровье:");
        knight.stabilizeHealth();
        messageService.printHealthDefense(knight);
        out.println("Что еще хотите сделать?");
    }

    private void repairArmor() {
        out.println("Что будем чинить? 1-2-3-4? Прочность элемента повышается на 30");
        Scanner strCraft = new Scanner(in);
        int digitValue;
        while (!StateGame.isCraftIntoHalt()) {
            String strCraftArmor = strCraft.nextLine();
            digitValue=returnCheckedDigit(strCraftArmor);
            if (digitValue >= 0 && digitValue < 4) {
                knight.attribute.defense[digitValue] += 30;
                StateGame.setCraftIntoHalt(true);
                out.println("Доспех починен! Что выберете еще?");
                break;
            } else {
                out.println("Введено недопустимое значение");
            }
        }
        messageService.printDefense(knight);
    }

    private int returnCheckedDigit(String strCraftArmor){
        try {
            return Integer.parseInt(strCraftArmor) - 1;
        } catch (NumberFormatException e){
            return -1;
        }
    }
}
