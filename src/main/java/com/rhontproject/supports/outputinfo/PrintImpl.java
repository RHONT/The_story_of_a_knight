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

    /**
     * Вывод на экран накопительной строки info_str_figth
     * в используемых методах она перезаписываеться, после того как выдала актуальную информацию
     */
    @Override
    public void printInfoFight() {
    }
    @Override
    public void printInventory() {
        String sb = "\n" +
                "Золота у вас: " + unit.money + "\n" +
                "Прочность щита в руке: " + unit.inventory[0] + "\n" +
                "Количество щитов: " + unit.inventory[1] + "\n" +
                "Коктейля молотова: " + unit.inventory[2] + "\n" +
                "Целебного зелья: " + unit.inventory[3] + "\n";
        out.println(sb);
    }
    @Override
    public void printDefense() {
        out.println("Состояние брони:\n" +
                "Шлем: " + unit.attribute.defense[0] +
                " Нагрудник: " + unit.attribute.defense[1] +
                " Нарукавники: " + unit.attribute.defense[2] +
                " Поножи: " + unit.attribute.defense[3]);
    }

}
