package com.rhontproject.acts;

import com.rhontproject.abstractUnitParent.Humanoid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.rhontproject.fabrica.ActsFabric.halt;
import static com.rhontproject.fabrica.ActsFabric.levelUp;
import static com.rhontproject.fabrica.UnitFabric.createKnight;
import static com.rhontproject.fabrica.UnitFabric.createKnightDark;
import static com.rhontproject.stateMethods.Utility.*;

public class Act_7 extends Act {
    @Override
    public void run() {
        printFromFile("[3].txt");
        scanner.nextLine();
        printFromFile("[4].txt");
        scanner.nextLine();
        fightVsShadow(createKnightDark(), createKnight());
        System.out.println("Нажмиет Enter для продолжения");

        halt();
        levelUp();

        printFromFile("[5].txt");
        System.out.println("Нажмиет Enter для продолжения");
        scanner.nextLine();
        fightVsShadow(createKnightDark(), createKnightDark(), createKnightDark());
    }
    private void fightVsShadow(Humanoid... enemy) {
        int round = 0;
        ArrayList<Humanoid> party = new ArrayList<>();
        party.add(knight);
        party.addAll(List.of(enemy));

        while (knight.Humanoid_is_alife() && (party.size() > 1)) {
            round++;
            System.out.println("*".repeat(5) + "ROUND " + round + "*".repeat(94));
            printBattleVsShadow(party);
            knight.Attack(knight, party.get(1));

            if (knight.vortex) {
                for (int i = 1; i < party.size(); i++) {
                    for (int j = 0; j < 4; j++) {
                        party.get(i).param_humanoid[j] -= 40;
                    }
                }
                knight.vortex = false;
            }


            knight.print_info_fight();
            for (int i = 1; i < party.size(); i++) {
                party.get(i).Attack(party.get(i), knight);
                party.get(i).print_info_fight();
            }

            for (int i = 1; i < party.size(); i++) {         // куда я полез... Ввел ветер, теперь перемены!
                if (!party.get(i).Humanoid_is_alife()) {
                    party.get(i).money = new Random().nextInt(90) + 100;
                    System.out.println("Враг пал, вы собрали с трупа: " + party.get(i).money + " золотых");
                    knight.money += party.get(i).money;
                    System.out.println();
                    party.remove(i);
                    i--;
                }
            }


            if (!knight.Humanoid_is_alife()) {
                System.out.println("Сэр Томас погиб. Его натура не выдержала вызова судьбы.");
                System.exit(0);
            }

        }
        knight.down_health();  // Зелье бодрит, и завышает временно характеристики здоровья. После боя, все приходит в норму.
    }
}
