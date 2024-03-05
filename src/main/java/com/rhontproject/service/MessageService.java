package com.rhontproject.service;

import com.rhontproject.unit.Unit;
import com.rhontproject.fabrics.units.Knight_In_The_Dark;
import com.rhontproject.unit.inventory.InventoryEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static java.lang.System.out;

/**
 * Класс для управления событий в игре
 */
@Component
@Scope("singleton")
public class MessageService {
    private final List<String> messages=new ArrayList<>();

    /**
     * Выводим все накопившиеся сообщения и очищаем список.
     */
    public void outputConsole(){
        messages.forEach(System.out::println);
        messages.clear();
    }

    public void add(String string){
        messages.add(string);
    }

    /**
     * Выводи в консоль в одну строку здоровье/броню/урон от оружия главного героя
     * @param unit
     */
    public void printHealthDefense() {
        String info;
        StringBuilder delimiter = new StringBuilder();

        info = ("Голова: " + knight.attribute.curHealth[0] + "/" + knight.attribute.baseHealth[0] + " [" + knight.attribute.defense[0] + "]" +
                " Тело: " + knight.attribute.curHealth[1] + "/" + knight.attribute.baseHealth[1] + " [" + knight.attribute.defense[1] + "]" +
                " Руки: " + knight.attribute.curHealth[2] + "/" + knight.attribute.baseHealth[2] + " [" + knight.attribute.defense[2] + "]" +
                " Ноги: " + knight.attribute.curHealth[3] + "/" + knight.attribute.baseHealth[3] + " [" + knight.attribute.defense[3] + "]" +
                " Сила оружия: " + knight.getWeapon().getPower());
        delimiter.append("-".repeat(info.length()));
        out.println(delimiter);
        out.println(knight.getName());
        out.println(info);
    }

    /**
     * Выводим построчно информацию об инвентаре главного героя.
     */
    public void printInventory() {
        String infoInventory =
                "Золота у вас: " + knight.getMoney() + "\n" +
                "Прочность щита в руке: " + knight.getDefenseWall().getDurability() + "\n" +
                "Количество щитов: " + knight.getDefenseWall().getAmountShield() + "\n" +
                "Коктейля молотова: " + knight.getInventorySet().get(InventoryEnum.MOLOTOV) + "\n" +
                "Целебного зелья: " + knight.getInventorySet().get(InventoryEnum.POTION) + "\n";
        out.println(infoInventory);
    }

    /**
     * Выводим в одну строку состояние брони главного героя
     */
    public void printDefense(Unit unit) {
        out.println("Состояние брони:\n" +
                "Шлем: " + unit.attribute.defense[0] +
                " Нагрудник: " + unit.attribute.defense[1] +
                " Нарукавники: " + unit.attribute.defense[2] +
                " Поножи: " + unit.attribute.defense[3]);
    }

    /**
     * В начале боя текстовое отображение о каждом персонаже:<br>
     *                Сэр Томас      Внезапный мертвец   Внезапный мертвец<br>
     * Шлем:          80 /80  [30]   80 /80  [6]         80 /80  [7]<br>
     * Нагрудник:     120/120 [30]   120/120 [6]         120/120 [16]<br>
     * Нарукавник:    50 /50  [30]   50 /50  [4]         50 /50  [3]<br>
     * Поножи:        50 /50  [30]   50 /50  [2]         50 /50  [4]<br>
     * Сила орудия:   23             23                  23<br>
     *
     * @param listUnit - все участники битвы
     * @param round - раунд по счету (инкриминируется для каждого боя)
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
        sb.append("\n").append(heroAttribute());
        return sb.toString();
    }

    /**
     * Приводит объект unit в string[] формата.
     * Служебный метод для {@link MessageService#printStandartBattleArea(List, int)}<br>
     * Внезапный мертвец <br>
     * 80 /80  [3]<br>
     * 120/120 [2]<br>
     * 50 /50  [1]<br>
     * 50 /50  [3]<br>
     * 23
     * @param unit
     */
    private static String[] converter(Unit unit) {
        String[] converted = new String[6];
        converted[0] = unit.getName();

        if (unit.getClass()== Knight_In_The_Dark.class) {
            Arrays.fill(converted,1,converted.length,"");
            return converted;
        }

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

    /**
     * Создаем готовый sb с подготовленной шапкой ***ROUND 5******
     * служебный метод для {@link MessageService#printStandartBattleArea(List, int)}
     * @param round - какой раунд по счету.
     */
    private StringBuilder getTemplateSb(int round) {
        StringBuilder sb = new StringBuilder();
        String header = "*".repeat(5) + "ROUND " + round + "*".repeat(94) + "\n";
        sb.append(header);
        return sb;
    }

    /**
     * Строка появляется после информации о состоянии каждого персонажа.
     * Это подсказка. Вероятность удара по каждой части тела противника.
     * И наличие предметов в инвентаре для главного героя
     * Служебный метод для {@link MessageService#printStandartBattleArea(List, int)}
     */
    private String heroAttribute() {
        StringBuilder sb =new StringBuilder();
        sb.append(chancesToAttack());
        sb.append("\n");
        sb.append(inventory());

        return sb.toString();
    }

    /**
     * Строка с информации о вероятности попасть по выбранной части тела
     * Служебный метод для {@link MessageService#heroAttribute()}
     */
    public String chancesToAttack(){
        return "Атакуй! 1 - голова "
                + (knight.getChanceAttack() - 10)
                + "% | 2 -тело " + (knight.getChanceAttack())
                + "% | 3 - руки " + (knight.getChanceAttack() - 20)
                + "% | 4 - ноги " + (knight.getChanceAttack() - 20);
    }

    /**
     * Строка с информации об инвентаре главного героя
     * Служебный метод для {@link MessageService#heroAttribute()}
     */
    public String inventory(){
        StringBuilder sb =new StringBuilder();
        for (var element: InventoryEnum.values()) {
            if (knight.getInventorySet().contains(element)) {
                sb.append(element.getName());
                sb.append(" - ");
                sb.append(knight.getInventorySet().get(element));
                sb.append("  ");
            }
        }
        sb.append("Щит - (").
                append(knight.getDefenseWall().getDurability()).
                append(") ").
                append(knight.getDefenseWall().getAmountShield());
        return sb.toString();
    }
}
