
package com.rhontproject;

import com.rhontproject.unit.*;
import com.rhontproject.stateMethods.StateGame;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

import static com.rhontproject.stateMethods.Utility.*;

public class Battle_area {

    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    static public StateGame stateGame = context.getBean("StateGame", StateGame.class);


    public static void main(String[] args) throws InterruptedException {

        Scanner history_stop = new Scanner(System.in);

        Knight first = context.getBean("Knight", Knight.class);
        first.setDefense(30, 30, 30, 30);

        Zombie second = context.getBean("Zombi", Zombie.class);
        second.setDefense(0, 20, 0, 30);

        Zombie third = context.getBean("Zombi", Zombie.class);
        third.setDefense(20, 50, 50, 50);


        OutLowBig outlaw_big = context.getBean("OutLowBig", OutLowBig.class);
        OutLowSmall outlaw_small = context.getBean("OutLowSmall", OutLowSmall.class);

        Bear bear = context.getBean("Bear", Bear.class);

        OutLawBridge outlaw_bridge_1 = context.getBean("OutLowBridge", OutLawBridge.class);
        outlaw_bridge_1.setDefense(0, 40, 10, 10);
        OutLawBridge outlaw_bridge_2 = context.getBean("OutLowBridge", OutLawBridge.class);
        outlaw_bridge_2.setDefense(15, 25, 10, 0);
        OutLawBridge outlaw_bridge_3 = context.getBean("OutLowBridge", OutLawBridge.class);
        outlaw_bridge_3.setDefense(0, 0, 30, 5);
        OutLawBridge outlaw_bridge_4 = context.getBean("OutLowBridge", OutLawBridge.class);
        outlaw_bridge_4.setDefense(50, 10, 20, 20);

        Knight_In_The_Dark knight_in_the_dark_1 = context.getBean("Knight_In_The_Dark", Knight_In_The_Dark.class);
        knight_in_the_dark_1.setDefense(70, 70, 10, 10);
        Knight_In_The_Dark knight_in_the_dark_2 = context.getBean("Knight_In_The_Dark", Knight_In_The_Dark.class);
        knight_in_the_dark_2.setDefense(50, 100, 30, 10);
        Knight_In_The_Dark knight_in_the_dark_3 = context.getBean("Knight_In_The_Dark", Knight_In_The_Dark.class);
        knight_in_the_dark_3.setDefense(0, 100, 50, 50);

        read_file("[1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();

        read_file("[1-1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(first, second, third);


        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        first.halt();    // привал

        first.level_up();  // повышение уровня

        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();

        first.print_inv_and_money();
        market_place(first, stateGame);

        read_file("Thief_1.txt");
        String bufer_string = history_stop.nextLine();
        Battle_area.stateGame.thief_1 = (bufer_string.equals("1"));

        read_file("out_law_story.txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(first, outlaw_small, outlaw_big);

        read_file("[2].txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(first, bear);

        first.halt();    // привал
        first.level_up();  // повышение уровня

        read_file("[2-1].txt");
        bridge(first, stateGame, outlaw_bridge_1, outlaw_bridge_2, outlaw_bridge_3, outlaw_bridge_4);
        bridge(first, stateGame, outlaw_bridge_1, outlaw_bridge_2, outlaw_bridge_3, outlaw_bridge_4);
        System.out.println(Arrays.toString(first.param_inventory));
        first.halt();    // привал
        first.level_up();

        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        read_file("[3].txt");
        history_stop.nextLine();
        read_file("[4].txt");
        history_stop.nextLine();

        fight_test_vs_shadow(first, knight_in_the_dark_1, knight_in_the_dark_2);
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        first.halt();    // привал
        first.level_up();

        read_file("[5].txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test_vs_shadow(first, knight_in_the_dark_1, knight_in_the_dark_2, knight_in_the_dark_3);
        first.halt();
        first.level_up();
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


