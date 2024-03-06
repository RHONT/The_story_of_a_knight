package com.rhontproject.service.events;

import com.rhontproject.unit.Unit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static java.lang.System.*;

/**
 * Сценарий проведения битвы, в один массив мы помещаем главного героя и противников.
 * Прописываем логику взаимодействия между персонажами
 */
@Component
public final class FightArea {

    public void fight(Unit hero, Unit... enemy) {
        int round = 0;
        ArrayList<Unit> party = new ArrayList<>();
        party.add(hero);
        party.addAll(List.of(enemy));

        while (hero.isAlive() && (party.size() > 1)) {
            round++;
            out.println(messageService.printStandartBattleArea(party, round));
            hero.attack(party.get(1));
            isVortexActive(hero, party);
            IntStream.range(1, party.size()).forEach(e -> party.get(e).attack(hero));
            getMoneyFromCorpses(hero, party);
            checkLifeHero(hero);
            messageService.outputConsole();

        }
        hero.stabilizeHealth();
        System.out.println("Нажмите Enter для продолжения");
    }

    /**
     * Флаг для магии АОЕ
     * @param hero
     * @param party
     */
    private void isVortexActive(Unit hero, ArrayList<Unit> party) {
        if (hero.vortex) {
            vortexPower(party);
            hero.vortex = false;
        }
    }

    /**
     * Проверка на - жив ли персонаж. Мертвым считается тот, у кого хотя бы одна часть тела = 0
     *
     * @param hero
     */
    private void checkLifeHero(Unit hero) {
        if (!hero.isAlive()) {
            messageService.add(hero.getName() + " погиб. Его натура не выдержала вызова судьбы.");
            exit(0);
        }
    }

    /**
     * Присваиваем персонажу деньги с павшего противника
     * @param hero
     * @param party
     */
    private void getMoneyFromCorpses(Unit hero, ArrayList<Unit> party) {
        for (int i = 1; i < party.size(); i++) {
            if (!party.get(i).isAlive()) {
                messageService.add("Враг пал, вы собрали с трупа: " + party.get(i).getMoney() + " золотых");
                hero.plusMoney(party.get(i).getMoney());
                party.remove(i);
                i--;
            }
        }
    }

    /**
     * Магия АОЕ
     * @param party
     */
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
