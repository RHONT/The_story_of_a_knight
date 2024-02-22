
package com.rhontproject;

import com.rhontproject.abstractUnitParent.Humanoid;
import com.rhontproject.stateMethods.StateGame;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

import static com.rhontproject.fabrica.UnitFabric.*;
import static com.rhontproject.stateMethods.Utility.*;

public class Battle_area {

    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    static public StateGame stateGame = context.getBean("StateGame", StateGame.class);


    public static void main(String[] args) {
        Humanoid knight=createKnight();

        Scanner history_stop = new Scanner(System.in);
        read_file("[1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();

        read_file("[1-1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(knight, createZombie(), createZombie());


        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        knight.halt();    // привал

        knight.level_up();  // повышение уровня

        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();

        knight.print_inv_and_money();
        market_place(knight, stateGame);

        read_file("Thief_1.txt");
        String bufer_string = history_stop.nextLine();
        Battle_area.stateGame.thief_1 = (bufer_string.equals("1"));

        read_file("out_law_story.txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(knight, createOutLowSmall(), createOutLowBig());

        read_file("[2].txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(knight, createBear());

        knight.halt();    // привал
        knight.level_up();  // повышение уровня

        read_file("[2-1].txt");
        bridge(knight, stateGame, createOutLowBridge(), createOutLowBridge(), createOutLowBridge(), createOutLowBridge());
        System.out.println(Arrays.toString(knight.param_inventory));
        knight.halt();    // привал
        knight.level_up();

        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        read_file("[3].txt");
        history_stop.nextLine();
        read_file("[4].txt");
        history_stop.nextLine();

        fight_test_vs_shadow(knight, createKnightDark(), createKnight());
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        knight.halt();    // привал
        knight.level_up();

        read_file("[5].txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test_vs_shadow(knight, createKnight(), createKnight(), createKnight());
        knight.halt();
        knight.level_up();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        read_file("[6].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        //first.halt();
        read_file("[7].txt");
        System.out.println("Нажмиет Enter для продолжения");

    }



}


