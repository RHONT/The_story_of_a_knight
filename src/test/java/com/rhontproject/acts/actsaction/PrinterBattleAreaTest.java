package com.rhontproject.acts.actsaction;

import com.rhontproject.abstractUnitParent.Humanoid;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static com.rhontproject.fabrica.UnitFabric.createKnight;
import static com.rhontproject.fabrica.UnitFabric.createZombie;

class PrinterBattleAreaTest {

    @Test
    void printBattleArea() {
        List<Humanoid> humanoidList=new ArrayList<>(List.of(createKnight(), createZombie(),createZombie()));
        PrinterBattleArea.printStandartBattleArea(humanoidList,5);
    }

    @Test
    void learn(){
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        Humanoid zombie = createZombie();
        int g=100;

        formatter.format("%"+g+"s%10s%10s", zombie.name,zombie.param_humanoid[0]+"/"+zombie.copy_param_humanoid[0],zombie.defense[0]);
        System.out.println(sb);
//        formatter.format("%-10s\n", "stack");


    }

    @Test
    void createHead(){
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        List<Humanoid> humanoidList=new ArrayList<>(List.of(createKnight(), createZombie(),createZombie()));

        String[][] formatUnits= humanoidList.stream().map(this::converter).toArray(String[][]::new);
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

    private String[] converter(Humanoid unit) {
        String[] converted=new String[6];
        converted[0]=unit.name;
        converted[5]=String.valueOf(unit.param_humanoid[4]);
        for (int i = 0; i <4 ; i++) {
            converted[i+1]=String.format(
                    "%-3s/%-3s [%s]",
                    unit.param_humanoid[i],
                    unit.copy_param_humanoid[i],
                    unit.defense[i]);
        }
        return converted;
    }
}