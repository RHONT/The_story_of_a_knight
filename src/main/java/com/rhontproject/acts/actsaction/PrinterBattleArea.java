package com.rhontproject.acts.actsaction;

import com.rhontproject.abstractUnitParent.Humanoid;

import java.util.List;

public class PrinterBattleArea {
    public static String printBattleArea(List<Humanoid> list, int round){
        StringBuilder battleInfo=new StringBuilder();
        battleInfo.append(roundLine(round));
        int maxlenght = 0;
        String[] str_final_print = new String[]
                {       "                " + list.get(0).name,
                        "Шлем:           " + intToStr(list.get(0).param_humanoid[0]) + "/" + intToStr(list.get(0).copy_param_humanoid[0]) + " [" + intToStr(list.get(0).defense[0]) + "]",
                        "Нагрудник:      " + intToStr(list.get(0).param_humanoid[1]) + "/" + intToStr(list.get(0).copy_param_humanoid[1]) + " [" + intToStr(list.get(0).defense[1]) + "]",
                        "Нарукавники:    " + intToStr(list.get(0).param_humanoid[2]) + "/" + intToStr(list.get(0).copy_param_humanoid[2]) + " [" + intToStr(list.get(0).defense[2]) + "]",
                        "Поножи:         " + intToStr(list.get(0).param_humanoid[3]) + "/" + intToStr(list.get(0).copy_param_humanoid[3]) + " [" + intToStr(list.get(0).defense[3]) + "]",
                        "Сила орудия:    " + intToStr(list.get(0).param_humanoid[4])};


        for (int i = 1; i < list.size(); i++) {

            String[] str = {list.get(i).name,
                    intToStr(list.get(i).param_humanoid[0]) + "/" + intToStr(list.get(i).copy_param_humanoid[0]) + " [" + intToStr(list.get(i).defense[0]) + "]",
                    intToStr(list.get(i).param_humanoid[1]) + "/" + intToStr(list.get(i).copy_param_humanoid[1]) + " [" + intToStr(list.get(i).defense[1]) + "]",
                    intToStr(list.get(i).param_humanoid[2]) + "/" + intToStr(list.get(i).copy_param_humanoid[2]) + " [" + intToStr(list.get(i).defense[2]) + "]",
                    intToStr(list.get(i).param_humanoid[3]) + "/" + intToStr(list.get(i).copy_param_humanoid[3]) + " [" + intToStr(list.get(i).defense[3]) + "]",
                    intToStr(list.get(i).param_humanoid[4])};

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
        return "";
    }

    private static String roundLine(int round) {
       return  "*".repeat(5) + "ROUND " + round + "*".repeat(94);
    }

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
}
