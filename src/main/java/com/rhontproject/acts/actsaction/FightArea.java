package com.rhontproject.acts.actsaction;

import com.rhontproject.abstractUnitParent.Humanoid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.rhontproject.acts.actsaction.PrinterBattleArea.printStandartBattleArea;
import static java.lang.System.exit;
import static java.lang.System.out;

public final class FightArea {
    public static void fight(Humanoid first, Humanoid... enemy) {
        int round = 0;
        ArrayList<Humanoid> list_participant = new ArrayList<>();
        list_participant.add(first);
        list_participant.addAll(List.of(enemy));

        while ((list_participant.get(0).Humanoid_is_alife()) && (list_participant.size() > 1)) {
            round++;
            out.println(printStandartBattleArea(list_participant, round));
            first.Attack(first, list_participant.get(1));

            if (first.vortex == true) {
                for (int i = 1; i < list_participant.size(); i++) {
                    for (int j = 0; j < 4; j++) {
                        list_participant.get(i).param_humanoid[j] -= 40;
                    }
                }
                first.vortex = false;
            }

            first.print_info_fight();
            for (int i = 1; i < list_participant.size(); i++) {
                list_participant.get(i).Attack(list_participant.get(i), first);
                list_participant.get(i).print_info_fight();
            }

            for (int i = 1; i < list_participant.size(); i++) {
                if (!list_participant.get(i).Humanoid_is_alife()) {
                    list_participant.get(i).money = new Random().nextInt(90) + 100;
                    out.println("Враг пал, вы собрали с трупа: " + list_participant.get(i).money + " золотых");
                    first.money += list_participant.get(i).money;
                    out.println();
                    list_participant.get(i).reborn();
                    list_participant.remove(i);
                    i--;
                }
            }

            if (!first.Humanoid_is_alife()) {
                out.println("Сэр Томас погиб. Его натура не выдержала вызова судьбы.");
                exit(0);
            }

        }
        first.down_health();
    }
}
