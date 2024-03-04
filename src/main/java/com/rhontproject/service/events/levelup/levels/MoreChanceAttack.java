package com.rhontproject.service.events.levelup.levels;

import com.rhontproject.service.events.levelup.AbstractLevelUp;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static com.rhontproject.fabrics.global.StateGame.setLevelUp;
import static java.lang.System.out;

public class MoreChanceAttack extends AbstractLevelUp {
    @Override
    public void levelUp() {
        knight.getWeapon().upPower(7);
        out.println
                ("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" +
                        knight.getWeapon().getPower());
        messageService.printHealthDefense(knight);
        setLevelUp(true);
    }

    @Override
    protected void initComponent() {
        articular = 2;
    }
}
