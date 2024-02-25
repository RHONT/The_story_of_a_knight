package com.rhontproject.acts.actsaction;

import com.rhontproject.abstractUnitParent.Humanoid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.rhontproject.acts.actsaction.PrinterBattleArea.printStandartBattleArea;
import static java.lang.System.exit;
import static java.lang.System.out;

public final class FightArea {
    public static void fight(Humanoid hero, Humanoid... enemy) {
        int round = 0;
        ArrayList<Humanoid> party = new ArrayList<>();
        party.add(hero);
        party.addAll(List.of(enemy));

        while (hero.isAlife() && (party.size() > 1)) {
            round++;
            out.println(printStandartBattleArea(party, round));
            hero.attack(hero, party.get(1));
            isVortexActive(hero, party);
            IntStream.range(1,party.size()).forEach(e->party.get(e).attack(party.get(e),hero));
            party.forEach(Humanoid::print_info_fight);
            сollectMoneyFromCorpses(hero, party);
            isAlifeHero(hero);
        }
        hero.down_health();
    }

    private static void isVortexActive(Humanoid hero, ArrayList<Humanoid> party) {
        if (hero.vortex) {
            vortexPower(party);
            hero.vortex = false;
        }
    }

    private static void isAlifeHero(Humanoid hero) {
        if (!hero.isAlife()) {
            out.println("Сэр Томас погиб. Его натура не выдержала вызова судьбы.");
            exit(0);
        }
    }

    private static void сollectMoneyFromCorpses(Humanoid hero, ArrayList<Humanoid> party) {
        for (int i = 1; i < party.size(); i++) {
            if (!party.get(i).isAlife()) {
                party.get(i).money = new Random().nextInt(90) + 100;
                out.println("Враг пал, вы собрали с трупа: " + party.get(i).money + " золотых");
                hero.money += party.get(i).money;
                out.println();
                party.get(i).reborn();
                party.remove(i);
                i--;
            }
        }
    }

    private static void vortexPower(ArrayList<Humanoid> party) {
        for (int i = 1; i < party.size(); i++) {
            for (int j = 0; j < 4; j++) {
                party.get(i).param_humanoid[j] -= 40;
            }
        }
    }
}
