package com.rhontproject.supports.outputinfo;

import com.rhontproject.abstractUnitParent.Unit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
@Scope("prototype")
public class PrintImpl implements Printable{
    Unit unit;

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    /**
     * Выводит информацию о состоянии здоровья и брони
     */
    @Override
    public void printHealthDefense() {
        String info_str;
        String spec_char = "";

        info_str = ("Голова: " + unit.param_humanoid[0] + "/" + unit.copy_param_humanoid[0] + " [" + unit.defense[0] + "]" +
                " Тело: " + unit.param_humanoid[1] + "/" + unit.copy_param_humanoid[1] + " [" + unit.defense[1] + "]" +
                " Руки: " + unit.param_humanoid[2] + "/" + unit.copy_param_humanoid[2] + " [" + unit.defense[2] + "]" +
                " Ноги: " + unit.param_humanoid[3] + "/" + unit.copy_param_humanoid[3] + " [" + unit.defense[3] + "]" +
                " Сила оружия: " + unit.param_humanoid[4]);
        for (int i = 0; i < info_str.length(); i++) {
            spec_char += "-";
        }

        out.println(spec_char);
        out.println(unit.name);
        out.println(info_str);
    }

    /**
     * Вывод на экран накопительной строки info_str_figth
     * в используемых методах она перезаписываеться, после того как выдала актуальную информацию
     */
    @Override
    public void printInfoFight() {
        out.println(unit.info_str_fight);
        unit.info_str_fight = "";
    }
    @Override
    public void printInventory() {
        String sb = "\n" +
                "Золота у вас: " + unit.money + "\n" +
                "Прочность щита в руке: " + unit.param_inventory[0] + "\n" +
                "Количество щитов: " + unit.param_inventory[1] + "\n" +
                "Коктейля молотова: " + unit.param_inventory[2] + "\n" +
                "Целебного зелья: " + unit.param_inventory[3] + "\n";
        out.println(sb);
    }
    @Override
    public void printDefense() {
        out.println("Состояние брони:\n" +
                "Шлем: " + unit.defense[0] +
                " Нагрудник: " + unit.defense[1] +
                " Нарукавники: " + unit.defense[2] +
                " Поножи: " + unit.defense[3]);
    }

}
