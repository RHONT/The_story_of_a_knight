package com.rhontproject.acts.actsaction;

import com.rhontproject.unit.Unit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static com.rhontproject.fabrics.UnitFabric.createKnight;
import static com.rhontproject.fabrics.UnitFabric.createZombie;
import static com.rhontproject.fabrics.GlobalVariable.messageService;

class PrinterBattleAreaTest {

    @Test
    void printBattleArea() {
        List<Unit> unitList =new ArrayList<>(List.of(createKnight(), createZombie(),createZombie()));
        messageService.printStandartBattleArea(unitList,5);
    }

    @Test
    void learn(){
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        Unit zombie = createZombie();
        int g=100;
        formatter.format("%"+g+"s%10s%10s", zombie.name,zombie.attribute.curHealth[0]+"/"+zombie.attribute.baseHealth[0],zombie.attribute.defense[0]);
        System.out.println(sb);
    }

    @Test
    void createHead(){
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        List<Unit> unitList =new ArrayList<>(List.of(createKnight(), createZombie(),createZombie()));

        String[][] formatUnits= unitList.stream().map(this::converter).toArray(String[][]::new);
        String[] info={"","Шлем:","Нагрудник:","Нарукавник:","Поножи:","Сила орудия:"};
        for (int i = 0; i < info.length; i++) {
            formatter.format("%-15s",info[i]);
            for (int j = 0; j < formatUnits.length; j++) {
                int nameLength=formatUnits[j][0].length();
                int space=nameLength>12?nameLength+3:15;
                formatter.format("%-"+space+"s",formatUnits[j][i]);
            }
            formatter.format("\n");
        }
        System.out.println(sb);

    }

    @Test
    void HumanoidToString(){
        String[] convert=converter(createZombie());
        for(var str:convert){
            System.out.println(str);
        }
    }

    private String[] converter(Unit unit) {
        String[] converted=new String[6];
        converted[0]=unit.name;
        converted[5]=String.valueOf(unit.attribute.curHealth[4]);
        for (int i = 0; i <4 ; i++) {
            converted[i+1]=String.format(
                    "%-3s/%-3s [%s]",
                    unit.attribute.curHealth[i],
                    unit.attribute.baseHealth[i],
                    unit.attribute.defense[i]);
        }
        return converted;
    }
}