package com.rhontproject.acts.actsaction;

import com.rhontproject.unit.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static com.rhontproject.fabrics.UnitFabric.createKnight;
import static com.rhontproject.fabrics.UnitFabric.createZombie;
import static com.rhontproject.fabrics.global.GlobalVariable.messageService;

class PrinterBattleArenaTest {

    @Test
    void printBattleArea() {
        List<Unit> unitList = new ArrayList<>(List.of(createKnight(), createZombie(), createZombie()));
        String actual = messageService.printStandartBattleArea(unitList, 5);
        assertNotNull(actual);
        assertTrue(actual.length() > 0);
    }

    @Test
    void createHead() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        List<Unit> unitList = new ArrayList<>(List.of(createKnight(), createZombie(), createZombie()));

        String[][] formatUnits = unitList.stream().map(this::converter).toArray(String[][]::new);
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
        System.out.println(sb);

    }

    @Test
    void HumanoidToString() {
        String[] convert = converter(createZombie());
        int countLines = 0;
        for (var ignored : convert) {
            countLines++;
        }
        assertTrue(countLines > 0);
    }

    private String[] converter(Unit unit) {
        String[] converted = new String[6];
        converted[0] = unit.getName();
        converted[5] = String.valueOf(unit.getWeapon().getPower());
        for (int i = 0; i < 4; i++) {
            converted[i + 1] = String.format(
                    "%-3s/%-3s [%s]",
                    unit.attribute.curHealth[i],
                    unit.attribute.baseHealth[i],
                    unit.attribute.defense[i]);
        }
        return converted;
    }
}