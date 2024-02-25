package com.rhontproject.acts.actsaction;

import com.rhontproject.abstractUnitParent.Humanoid;
import com.rhontproject.unit.Knight_In_The_Dark;

import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public final class PrinterBattleArea {
    /**
     * Перед нанесением удара показывает текущие состояния для каждого юнита:
     *
     *                Сэр Томас      Внезапный мертвец   Внезапный мертвец
     * Шлем:          80 /80  [30]   80 /80  [6]         80 /80  [7]
     * Нагрудник:     120/120 [30]   120/120 [6]         120/120 [16]
     * Нарукавник:    50 /50  [30]   50 /50  [4]         50 /50  [3]
     * Поножи:        50 /50  [30]   50 /50  [2]         50 /50  [4]
     * Сила орудия:   23             23                  23
     *
     * @param listUnit
     * @param round
     * @return
     */
    public static String printStandartBattleArea(List<Humanoid> listUnit, int round) {
        StringBuilder sb=getTemplateSb(round);
        try (Formatter formatter = new Formatter(sb)) {
            String[][] formatUnits = listUnit.stream().map(PrinterBattleArea::converter).toArray(String[][]::new);
            String[] info = {"", "Шлем:", "Нагрудник:", "Нарукавник:", "Поножи:", "Сила орудия:"};
            for (int i = 0; i < info.length; i++) {
                formatter.format("%-15s", info[i]);
                for (int j = 0; j < formatUnits.length; j++) {
                    int nameLength = formatUnits[j][0].length();
                    int space = nameLength > 12 ? nameLength + 3 : 15;
                    formatter.format("%-" + space + "s", formatUnits[j][i]);
                }
                formatter.format("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Приводит объект unit в string[] формата:
     * Внезапный мертвец
     * 80 /80  [3]
     * 120/120 [2]
     * 50 /50  [1]
     * 50 /50  [3]
     * 23
     * @param unit
     * @return
     */
    private static String[] converter(Humanoid unit) {
        String[] converted = new String[6];
        converted[0] = unit.name;

        if (unit.getClass()== Knight_In_The_Dark.class) {
            Arrays.fill(converted,1,converted.length,"");
            return converted;
        }

        converted[5] = String.valueOf(unit.param_humanoid[4]);
        for (int i = 0; i < 4; i++) {
            converted[i + 1] = String.format(
                    "%-3s/%-3s [%s]",
                    unit.param_humanoid[i],
                    unit.copy_param_humanoid[i],
                    unit.defense[i]);
        }
        return converted;
    }

    /**
     * Создаем готовый sb с подготовленной шапкой ***ROUND 5******
     * @param round
     * @return
     */
    private static StringBuilder getTemplateSb(int round) {
        StringBuilder sb = new StringBuilder();
        String header = "*".repeat(5) + "ROUND " + round + "*".repeat(94) + "\n";
        sb.append(header);
        return sb;
    }
}
