package com.rhontproject.acts.actsaction;

import com.rhontproject.abstractUnitParent.Humanoid;
import com.rhontproject.unit.Knight_In_The_Dark;

import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public final class PrinterBattleArea {
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

    private static StringBuilder getTemplateSb(int round) {
        StringBuilder sb = new StringBuilder();
        String header = "*".repeat(5) + "ROUND " + round + "*".repeat(94) + "\n";
        sb.append(header);
        return sb;
    }
}
