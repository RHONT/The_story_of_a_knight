package com.rhontproject.service.events.levelup.levels;

import com.rhontproject.service.events.levelup.AbstractLevelUp;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static com.rhontproject.fabrics.global.StateGame.setLevelUp;
import static java.lang.System.out;

public class MoreHealth extends AbstractLevelUp {
    @Override
    public void levelUp() {
        for (int i = 0; i < 4; i++) {
            knight.attribute.curHealth[i] += 10;
            knight.attribute.baseHealth[i] += 10;
        }
        out.println("Ваше здоровье увеличено на 10 единиц по каждому пункту.");
        messageService.printHealthDefense();
        setLevelUp(true);
    }

    @Override
    protected void initComponent() {
        articular = 1;
        messageInMenu="Как сильно бьется мое сердце, словно удары молота о наковальню. Мое тело идеальный механизм!";
    }
}
