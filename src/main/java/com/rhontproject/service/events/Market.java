package com.rhontproject.service.events;

import com.rhontproject.service.events.marketgoods.MarketObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static com.rhontproject.fabrics.global.StateGame.isMarketExit;
import static com.rhontproject.fabrics.global.StateGame.setMarketExit;
import static java.lang.System.in;

@Component
public class Market {
    @Autowired
    @Qualifier("marketObjets")
    Set<MarketObject> listGoods;
    Map<String,MarketObject> shelves;


    public void run(){
        if (shelves==null) {
            shelves=putOnShelves();
        }
        messageService.printInventory(knight);
        printMenu();
        Scanner scanMarket = new Scanner(in);

        while (!isMarketExit()) {
            final String finalIndexGoods=scanMarket.nextLine();
            shelves.keySet().stream().
                    filter(e-> Objects.equals(e, finalIndexGoods)).findFirst().
                    ifPresentOrElse(e->shelves.get(e).buy(),()-> System.out.println("Введено неверное значение"));
        }
        setMarketExit(false);
    }

    private void printMenu(){
        for (MarketObject element:listGoods) {
            System.out.printf("%d - %s - %s золотых\n",element.getArticular(),element.getName(),element.getCost());
        }
    }

    private Map<String,MarketObject> putOnShelves() {
        Map<String,MarketObject> resultMap=new LinkedHashMap<>();
        for (MarketObject element:listGoods) {
            resultMap.put(String.valueOf(element.getArticular()),element);
        }
        return resultMap;
    }



}
