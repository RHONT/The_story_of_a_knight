package com.rhontproject.service.events;

import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static java.lang.System.*;
@Component
public final class FightArea {

    public void fight(Unit hero, Unit... enemy) {
        int round = 0;
        ArrayList<Unit> party = new ArrayList<>();
        party.add(hero);
        party.addAll(List.of(enemy));

        while (hero.isAlife() && (party.size() > 1)) {
            round++;
            out.println(messageService.printStandartBattleArea(party, round));
            hero.attack(party.get(1));
            isVortexActive(hero, party);
            IntStream.range(1, party.size()).forEach(e -> party.get(e).attack(hero));
            сollectMoneyFromCorpses(hero, party);
            checkLifeHero(hero);
            messageService.outputConsole();

        }
        hero.stabilizeHealth();
        System.out.println("Нажмите Enter для продолжения");
    }

    private void isVortexActive(Unit hero, ArrayList<Unit> party) {
        if (hero.vortex) {
            vortexPower(party);
            hero.vortex = false;
        }
    }

    private void checkLifeHero(Unit hero) {
        if (!hero.isAlife()) {
            messageService.add(hero.name + " погиб. Его натура не выдержала вызова судьбы.");
            exit(0);
        }
    }

    private void сollectMoneyFromCorpses(Unit hero, ArrayList<Unit> party) {
        for (int i = 1; i < party.size(); i++) {
            if (!party.get(i).isAlife()) {
                party.get(i).money = new Random().nextInt(90) + 100;
                messageService.add("Враг пал, вы собрали с трупа: " + party.get(i).money + " золотых");
                hero.money += party.get(i).money;
                party.remove(i);
                i--;
            }
        }
    }

    private void vortexPower(ArrayList<Unit> party) {
        IntStream.range(1, party.size()).forEach(
                index -> {
                    IntStream.range(0, 4).forEach(
                            innerIndex ->
                                    party.get(index).attribute.curHealth[innerIndex] -= 40);
                }
        );
    }

}
