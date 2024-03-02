package com.rhontproject.unit.attack.typeatack;

import com.rhontproject.unit.attack.DuelScenario;
import com.rhontproject.unit.Statless.NameStates;
import com.rhontproject.unit.Unit;
import com.rhontproject.unit.inventory.InventoryEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static java.lang.System.*;

@Component
@Scope("prototype")
public class StandardDuelScenarioImpl implements DuelScenario {

    private Unit attacking;
    private Unit victim;
    int attackPower;

    @Override
    public void attacking(Unit attacking, Unit victim) {

        this.attacking = attacking;
        this.victim = victim;
        this.attacking.getStateHolder().activate();
        attackPower = this.attacking.getWeapon().getPower();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputConsole;
            if (!attacking.isHero) {
                inputConsole = String.valueOf((new Random().nextInt(3) + 1));
            } else {
                inputConsole = scanner.nextLine().toLowerCase();
            }
            switch (inputConsole) {
                case ("w"):
                    activeVortex();
                    return;
                case ("s"):
                    if (attacking.getDefenseWall().loadShield()) {
                        out.println(attacking.name + " подготовил щит");
                        break;
                    } else {
                        out.println("У вас нет щитов");
                    }
                    break;
                case ("m"):
                    if (this.attacking.getInventorySet().get(InventoryEnum.MOLOTOV) > 0) {
                        this.attacking.getInventorySet().use(InventoryEnum.MOLOTOV);
                        this.victim.getStateHolder().activeSelectState(NameStates.BURN);
                        out.println(victim.name + " горит!");
                        return;
                    } else {
                        out.println("У вас нет Молотова");
                    }
                    break;
                case ("p"):
                    if (this.attacking.getInventorySet().get(InventoryEnum.POTION) > 0) {
                        this.attacking.getInventorySet().use(InventoryEnum.POTION);
                        drinkPotion(70);
                        out.println(attacking.name + " выпил зелье");
                        break;
                    } else {
                        out.println("У вас нет зелья!");
                    }
                    break;
                case ("1"):
                case ("2"):
                case ("3"):
                case ("4"):
                    attacking.getWeapon().attackVictim(Integer.parseInt(inputConsole), victim);
                    return;
                default:
                    out.println("Введено неправильное значение.\n" +
                            "Атакуйте часть тела (1-4) \n" +
                            "Или совершите действие (Щит, Молотов, Зелье)");
            }
        }
    }


    private void activeVortex() {
        attacking.vortex = true;
        messageService.add(attacking.name + " разрываете врагов мощным порывом ветра! "
                + "Урон каждому составил по 40 единиц!");
    }

    private void drinkPotion(int powerPotion) {
        for (int i = 0; i < 4; i++) {
            attacking.attribute.curHealth[i] += powerPotion;
        }
        messageService.add(attacking.name + " исцелился на " + powerPotion + " очков");
    }
}
