package com.rhontproject.service.events;

import com.rhontproject.service.events.levelup.AbstractLevelUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import static com.rhontproject.fabrics.global.StateGame.*;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Механика привала после битвы.
 */
@Component
public class LevelUp {
    @Autowired
    @Qualifier("levelUps")
    Set<AbstractLevelUp> listLevelUps;
    Map<String,AbstractLevelUp> levels;


    public void run(){
        if (levels ==null) {
            levels =putOnShelves();
        }
        printMenu();
        Scanner scanMarket = new Scanner(in);
        while (!isLevelUp()) {
            final String indexLevelUp=scanMarket.nextLine();
            levels.keySet().stream().
                    filter(e-> Objects.equals(e, indexLevelUp)).findFirst().
                    ifPresentOrElse(e-> levels.get(e).levelUp(),()-> System.out.println("Введено неверное значение"));
        }
        setLevelUp(false);
    }





    private void printMenu(){
        out.println("Сэр Томас отдышался. Оглядел поле боя и решил задуматься, точнее некоторые мысли\n" +
                "назойливые как комары заставляли его это сделать. Не в силах сражаться с самим собой он впустил к себе одну из них.");
        for (AbstractLevelUp element:listLevelUps) {
            System.out.printf("%d - %s%n",element.getArticular(),element.getMessageInMenu());
        }
    }

    private Map<String,AbstractLevelUp> putOnShelves() {
        Map<String,AbstractLevelUp> resultMap=new LinkedHashMap<>();
        for (AbstractLevelUp element: listLevelUps) {
            resultMap.put(String.valueOf(element.getArticular()),element);
        }
        return resultMap;
    }
}
