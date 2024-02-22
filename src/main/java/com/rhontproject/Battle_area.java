package com.rhontproject;

import com.rhontproject.stateMethods.StateGame;
import static com.rhontproject.fabrica.ActsFabric.*;

public class Battle_area {
    static public StateGame stateGame = new StateGame();

    public static void main(String[] args) {
        act_1();
        act_2();
        halt();
        levelUp();

//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//
//        knight.print_inv_and_money();
//        market_place(knight, stateGame);
//
//        read_file("Thief_1.txt");
//        String bufer_string = historyNextStep.nextLine();
//        Battle_area.stateGame.thief_1 = (bufer_string.equals("1"));
//
//        read_file("out_law_story.txt");
//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//        fight(knight, createOutLowSmall(), createOutLowBig());
//
//        read_file("[2].txt");
//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//        fight(knight, createBear());
//
//        knight.halt();    // привал
//        knight.level_up();  // повышение уровня
//
//        read_file("[2-1].txt");
//        bridge(knight, stateGame, createOutLowBridge(), createOutLowBridge(), createOutLowBridge(), createOutLowBridge());
//        System.out.println(Arrays.toString(knight.param_inventory));
//        knight.halt();    // привал
//        knight.level_up();
//
//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//        read_file("[3].txt");
//        historyNextStep.nextLine();
//        read_file("[4].txt");
//        historyNextStep.nextLine();
//
//        fight_test_vs_shadow(knight, createKnightDark(), createKnight());
//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//        knight.halt();    // привал
//        knight.level_up();
//
//        read_file("[5].txt");
//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//        fight_test_vs_shadow(knight, createKnight(), createKnight(), createKnight());
//        knight.halt();
//        knight.level_up();
//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//        read_file("[6].txt");
//        System.out.println();
//        System.out.println("Нажмиет Enter для продолжения");
//        historyNextStep.nextLine();
//        //first.halt();
//        read_file("[7].txt");
//        System.out.println("Нажмиет Enter для продолжения");

    }



}


