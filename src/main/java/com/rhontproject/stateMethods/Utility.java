package com.rhontproject.stateMethods;

import com.rhontproject.abstractUnitParent.Humanoid;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Utility {

    public static String str(int a) {

        String buf_st;
        buf_st = Integer.toString(a);
        return buf_st;
    }  // служебная вещь. переводит быстро int в String.


    public static String space(String s, int a) {
        String str = "";
        int buf;
        buf = a - s.length();
        for (int i = 0; i < buf; i++) {
            str = str + " ";
        }
        return str;
    }  // Добавляет нужное количество пробелов(функци связана с ровным выводами по столбцам)

    public static void print_battle_life(Humanoid a, Humanoid b) {
        int maxlenght = 0;

        String[][] str = {{a.name, b.name},

                {"Шлем:           " + str(a.param_humanoid[0]) + "/" + str(a.copy_param_humanoid[0]) + " [" + str(a.defense[0]) + "]",
                        str(b.param_humanoid[0]) + "/" + str(b.copy_param_humanoid[0]) + " [" + str(b.defense[0]) + "]"},
                {"Нагрудник:      " + str(a.param_humanoid[1]) + "/" + str(a.copy_param_humanoid[1]) + " [" + str(a.defense[1]) + "]",
                        str(b.param_humanoid[1]) + "/" + str(b.copy_param_humanoid[1]) + " [" + str(b.defense[1]) + "]"},
                {"Нарукавники:    " + str(a.param_humanoid[2]) + "/" + str(a.copy_param_humanoid[2]) + " [" + str(a.defense[2]) + "]",
                        str(b.param_humanoid[2]) + "/" + str(b.copy_param_humanoid[2]) + " [" + str(b.defense[2]) + "]"},
                {"Поножи:         " + str(a.param_humanoid[3]) + "/" + str(a.copy_param_humanoid[3]) + " [" + str(a.defense[3]) + "]",
                        str(b.param_humanoid[3]) + "/" + str(b.copy_param_humanoid[3]) + " [" + str(b.defense[3]) + "]"},
                {"Сила орудия:    " + str(a.param_humanoid[4]), str(b.param_humanoid[4])}};


        for (String[] z : str) {
            if (z[0].length() > maxlenght) {
                maxlenght = z[0].length();
            }
            ;
        }

        maxlenght += 4;

        for (int i = 0; i < str.length; i++) {
            str[i][0] = str[i][0] + space(str[i][0], maxlenght) + str[i][1];
            System.out.println(str[i][0]);
        }
    }


    public static void read_file(String str) {
        try (InputStream inputStream = Utility.class.getResourceAsStream("/stories/" + str);
        ) {
            if (inputStream != null) {
                try (Scanner scan_for_read = new Scanner(inputStream);
                ) {
                    while (scan_for_read.hasNext()) {
                        System.out.println(scan_for_read.nextLine());
                    }
                }
            } else {
                System.out.println("Часть истории не найдена");
            }
        } catch (IOException ignored) {
        }
    }

    public static void print_battle_life_vs_shadow(ArrayList<Humanoid> list) {
        int maxlenght = 0;
        String[] str_final_print = new String[]
                {"                " + list.get(0).name,
                        "Шлем:           " + str(list.get(0).param_humanoid[0]) + "/" + str(list.get(0).copy_param_humanoid[0]) + " [" + str(list.get(0).defense[0]) + "]",
                        "Нагрудник:      " + str(list.get(0).param_humanoid[1]) + "/" + str(list.get(0).copy_param_humanoid[1]) + " [" + str(list.get(0).defense[1]) + "]",
                        "Нарукавники:    " + str(list.get(0).param_humanoid[2]) + "/" + str(list.get(0).copy_param_humanoid[2]) + " [" + str(list.get(0).defense[2]) + "]",
                        "Поножи:         " + str(list.get(0).param_humanoid[3]) + "/" + str(list.get(0).copy_param_humanoid[3]) + " [" + str(list.get(0).defense[3]) + "]",
                        "Сила орудия:    " + str(list.get(0).param_humanoid[4])};


        for (int i = 1; i < list.size(); i++) {

            String[] str = {list.get(i).name, "", "", "", "", ""};

            for (String z : str_final_print) {
                if (z.length() > maxlenght) {
                    maxlenght = z.length();
                }
            }
            maxlenght += 4;

            for (int q = 0; q < str.length; q++) {
                str_final_print[q] = str_final_print[q].concat(space(str_final_print[q], maxlenght)).concat(str[q]);

            }
        }
        for (String s : str_final_print) {
            System.out.println(s);

        }
    }

    public static void fight_test_vs_shadow(Humanoid first, Humanoid... enemy) {
        int round = 0;
        int sum_enemy = enemy.length;
        //System.out.println(sum_enemy);
        ArrayList<Humanoid> list_participant = new ArrayList<>();
        list_participant.add(first);

        for (int i = 0; i < sum_enemy; i++) {
            list_participant.add(enemy[i]);
        }

        while ((list_participant.get(0).Humanoid_is_alife()) && (list_participant.size() > 1)) {
            round++;
            System.out.println("*****" + "ROUND " + round + "**********************************************************************************************");
            print_battle_life_vs_shadow(list_participant);
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

            for (int i = 1; i < list_participant.size(); i++) {         // куда я полез... Ввел ветер, теперь перемены!
                if (!list_participant.get(i).Humanoid_is_alife()) {
                    list_participant.get(i).money = new Random().nextInt(90) + 100;
                    System.out.println("Враг пал, вы собрали с трупа: " + list_participant.get(i).money + " золотых");
                    first.money += list_participant.get(i).money;
                    System.out.println();
                    list_participant.get(i).reborn();
                    list_participant.remove(i);
                    i--;
                }
            }


            if (!first.Humanoid_is_alife()) {
                System.out.println("Сэр Томас погиб. Его натура не выдержала вызова судьбы.");
                System.exit(0);
            }

        }
        first.down_health();  // Зелье бодрит, и завышает временно характеристики здоровья. После боя, все приходит в норму.
    }

    public static void print_battle_life_test(ArrayList<Humanoid> list) {
        int maxlenght = 0;
        String[] str_final_print = new String[]
                {"                " + list.get(0).name,
                        "Шлем:           " + str(list.get(0).param_humanoid[0]) + "/" + str(list.get(0).copy_param_humanoid[0]) + " [" + str(list.get(0).defense[0]) + "]",
                        "Нагрудник:      " + str(list.get(0).param_humanoid[1]) + "/" + str(list.get(0).copy_param_humanoid[1]) + " [" + str(list.get(0).defense[1]) + "]",
                        "Нарукавники:    " + str(list.get(0).param_humanoid[2]) + "/" + str(list.get(0).copy_param_humanoid[2]) + " [" + str(list.get(0).defense[2]) + "]",
                        "Поножи:         " + str(list.get(0).param_humanoid[3]) + "/" + str(list.get(0).copy_param_humanoid[3]) + " [" + str(list.get(0).defense[3]) + "]",
                        "Сила орудия:    " + str(list.get(0).param_humanoid[4])};


        for (int i = 1; i < list.size(); i++) {

            String[] str = {list.get(i).name,
                    str(list.get(i).param_humanoid[0]) + "/" + str(list.get(i).copy_param_humanoid[0]) + " [" + str(list.get(i).defense[0]) + "]",
                    str(list.get(i).param_humanoid[1]) + "/" + str(list.get(i).copy_param_humanoid[1]) + " [" + str(list.get(i).defense[1]) + "]",
                    str(list.get(i).param_humanoid[2]) + "/" + str(list.get(i).copy_param_humanoid[2]) + " [" + str(list.get(i).defense[2]) + "]",
                    str(list.get(i).param_humanoid[3]) + "/" + str(list.get(i).copy_param_humanoid[3]) + " [" + str(list.get(i).defense[3]) + "]",
                    str(list.get(i).param_humanoid[4])};

            for (String z : str_final_print) {
                if (z.length() > maxlenght) {
                    maxlenght = z.length();
                }
            }
            maxlenght += 4;

            for (int q = 0; q < str.length; q++) {
                str_final_print[q] = str_final_print[q].concat(space(str_final_print[q], maxlenght)).concat(str[q]);

            }
        }
        for (String s : str_final_print) {
            System.out.println(s);

        }

    }

    public static void fight(Humanoid first, Humanoid... enemy) {
        int round = 0;
        ArrayList<Humanoid> list_participant = new ArrayList<>();
        list_participant.add(first);
        list_participant.addAll(List.of(enemy));

        while ((list_participant.get(0).Humanoid_is_alife()) && (list_participant.size() > 1)) {
            round++;
            System.out.println("*".repeat(5) + "ROUND " + round + "*".repeat(94));
            print_battle_life_test(list_participant);
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
                    System.out.println("Враг пал, вы собрали с трупа: " + list_participant.get(i).money + " золотых");
                    first.money += list_participant.get(i).money;
                    System.out.println();
                    list_participant.get(i).reborn();
                    list_participant.remove(i);
                    i--;
                }
            }


            if (!first.Humanoid_is_alife()) {
                System.out.println("Сэр Томас погиб. Его натура не выдержала вызова судьбы.");
                System.exit(0);
            }

        }
        first.down_health();
    }

    /**
     * @param knight главный герой
     * @param enemy  враги
     *               метод запускающий события на мосту.
     */
    public static void bridge(Humanoid knight, StateGame stateGame, Humanoid... enemy) {
        while (!stateGame.event_on_bridge) {
            String for_market_scanner;
            Scanner scan_market = new Scanner(System.in);
            for_market_scanner = scan_market.nextLine();
            switch (for_market_scanner) {
                case ("2"):
                    if (knight.money > 400) {
                        knight.money -= 400;

                        knight.chance_to_attack -= 7;
                        System.out.println("Сэр Томас ощутил жжение в области своего достоинства. " +
                                "вполне может быть, это было и верное решени...\nВаша уверенность упала(-7) и теперь ваша базовая" +
                                "меткость составляет: " + knight.chance_to_attack);

                        stateGame.event_on_bridge = true;

                        break;
                    } else {
                        knight.chance_to_attack -= 15;
                        System.out.println("У вас не нашлось нужной суммы. Жулики забрали все что у вас есть, включая ваш инвентарь" +
                                "\nТак жалко сэр Томас себя еще никогда не ощущал. \nВаша уверенность упала(-15) и теперь ваша базовая" +
                                "меткость составляет:  " + knight.chance_to_attack);
                        knight.param_inventory = Arrays.stream(knight.param_inventory).map(e -> {
                            e = 0;
                            return e;
                        }).toArray();
                        knight.money = 0;
                        stateGame.event_on_bridge = true;
                        break;
                    }
                case ("1"):
                    fight(knight, enemy);
                    stateGame.event_on_bridge = true;
                    break;
                default:
                    System.out.println("Значение введено неправильно");
            }
        }
        stateGame.event_on_bridge = false;

    }

}
