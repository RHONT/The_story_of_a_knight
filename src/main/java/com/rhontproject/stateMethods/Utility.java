package com.rhontproject.stateMethods;

import com.rhontproject.abstractUnitParent.Humanoid;
import com.rhontproject.acts.actsaction.PrinterBattleArea;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.rhontproject.acts.actsaction.PrinterBattleArea.*;
import static java.lang.System.*;

public class Utility {

    public static String intToStr(int a) {
        return Integer.toString(a);
    }

    /**
     *Добавляет нужное количество пробелов(функции связана с ровным выводами по столбцам)
     */
    public static String space(String s, int a) {
        StringBuilder spaces = new StringBuilder();
        int buf = a - s.length();
        spaces.append(" ".repeat(buf));
        return spaces.toString();
    }

    public static void printFromFile(String str) {
        try (InputStream inputStream = Utility.class.getResourceAsStream("/stories/" + str);
        ) {
            if (inputStream != null) {
                try (Scanner scan_for_read = new Scanner(inputStream);
                ) {
                    while (scan_for_read.hasNext()) {
                        out.println(scan_for_read.nextLine());
                    }
                }
            } else {
                out.println("Часть истории не найдена");
            }
        } catch (IOException ignored) {
        }
    }

    public static void printBattleVsShadow(ArrayList<Humanoid> list) {
        int maxlenght = 0;
        String[] str_final_print = new String[]
                {"                " + list.get(0).name,
                        "Шлем:           " + intToStr(list.get(0).param_humanoid[0]) + "/" + intToStr(list.get(0).copy_param_humanoid[0]) + " [" + intToStr(list.get(0).defense[0]) + "]",
                        "Нагрудник:      " + intToStr(list.get(0).param_humanoid[1]) + "/" + intToStr(list.get(0).copy_param_humanoid[1]) + " [" + intToStr(list.get(0).defense[1]) + "]",
                        "Нарукавники:    " + intToStr(list.get(0).param_humanoid[2]) + "/" + intToStr(list.get(0).copy_param_humanoid[2]) + " [" + intToStr(list.get(0).defense[2]) + "]",
                        "Поножи:         " + intToStr(list.get(0).param_humanoid[3]) + "/" + intToStr(list.get(0).copy_param_humanoid[3]) + " [" + intToStr(list.get(0).defense[3]) + "]",
                        "Сила орудия:    " + intToStr(list.get(0).param_humanoid[4])};


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
            out.println(s);

        }
    }


    public static void fight(Humanoid first, Humanoid... enemy) {
        int round = 0;
        ArrayList<Humanoid> list_participant = new ArrayList<>();
        list_participant.add(first);
        list_participant.addAll(List.of(enemy));

        while ((list_participant.get(0).Humanoid_is_alife()) && (list_participant.size() > 1)) {
            round++;
            out.println(printBattleArea(list_participant, round));
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
