package com.rhontproject.service;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.units.Knight_In_The_Dark;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

import static java.lang.System.out;

@Component
@Scope("singleton")
public class MessageService {
    private final List<String> messages=new ArrayList<>();

    public void outputConsole(){
        messages.forEach(System.out::println);
        messages.clear();
    }

    public void add(String string){
        messages.add(string);
    }

    public void printHealthDefense(Unit unit) {
        String info_str;
        String spec_char = "";

        info_str = ("Голова: " + unit.attribute.curHealth[0] + "/" + unit.attribute.baseHealth[0] + " [" + unit.attribute.defense[0] + "]" +
                " Тело: " + unit.attribute.curHealth[1] + "/" + unit.attribute.baseHealth[1] + " [" + unit.attribute.defense[1] + "]" +
                " Руки: " + unit.attribute.curHealth[2] + "/" + unit.attribute.baseHealth[2] + " [" + unit.attribute.defense[2] + "]" +
                " Ноги: " + unit.attribute.curHealth[3] + "/" + unit.attribute.baseHealth[3] + " [" + unit.attribute.defense[3] + "]" +
                " Сила оружия: " + unit.getWeapon().getPower());
        for (int i = 0; i < info_str.length(); i++) {
            spec_char += "-";
        }

        out.println(spec_char);
        out.println(unit.name);
        out.println(info_str);
    }

    public void printInventory(Unit unit) {
        String sb = "\n" +
                "Золота у вас: " + unit.money + "\n" +
                "Прочность щита в руке: " + unit.inventory[0] + "\n" +
                "Количество щитов: " + unit.inventory[1] + "\n" +
                "Коктейля молотова: " + unit.inventory[2] + "\n" +
                "Целебного зелья: " + unit.inventory[3] + "\n";
        out.println(sb);
    }

    public void printDefense(Unit unit) {
        out.println("Состояние брони:\n" +
                "Шлем: " + unit.attribute.defense[0] +
                " Нагрудник: " + unit.attribute.defense[1] +
                " Нарукавники: " + unit.attribute.defense[2] +
                " Поножи: " + unit.attribute.defense[3]);
    }







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
    public String printStandartBattleArea(List<Unit> listUnit, int round) {
        StringBuilder sb=getTemplateSb(round);
        try (Formatter formatter = new Formatter(sb)) {
            String[][] formatUnits = listUnit.stream().map(MessageService::converter).toArray(String[][]::new);
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
        sb.append("\n").append(heroAttribute(listUnit.get(0)));
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
    private static String[] converter(Unit unit) {
        String[] converted = new String[6];
        converted[0] = unit.name;

        if (unit.getClass()== Knight_In_The_Dark.class) {
            Arrays.fill(converted,1,converted.length,"");
            return converted;
        }

        converted[5] = String.valueOf(unit.attribute.curHealth[4]);
        for (int i = 0; i < 4; i++) {
            converted[i + 1] = String.format(
                    "%-3s/%-3s [%s]",
                    unit.attribute.curHealth[i],
                    unit.attribute.baseHealth[i],
                    unit.attribute.defense[i]);
        }
        return converted;
    }

    /**
     * Создаем готовый sb с подготовленной шапкой ***ROUND 5******
     * @param round
     * @return
     */
    private StringBuilder getTemplateSb(int round) {
        StringBuilder sb = new StringBuilder();
        String header = "*".repeat(5) + "ROUND " + round + "*".repeat(94) + "\n";
        sb.append(header);
        return sb;
    }

    private String heroAttribute(Unit hero) {
        return "Атакуй! 1 - голова "
                + (hero.chance_to_attack - 10)
                + "% | 2 -тело " + (hero.chance_to_attack)
                + "% | 3 - руки " + (hero.chance_to_attack - 20)
                + "% | 4 - ноги " + (hero.chance_to_attack - 20)
                + "% | Символ  s = (щит)  m = (коктейль Молотова)  p=(Зелье исцеления)";
    }
}
