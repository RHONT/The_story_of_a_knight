package com.rhontproject.service.events.levelup.levels;

import com.rhontproject.service.events.levelup.AbstractLevelUp;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.fabrics.global.GlobalVariable.messageService;
import static com.rhontproject.fabrics.global.StateGame.setLevelUp;
import static java.lang.System.out;

/**
 * Увеличение урона
 */
public class MoreDamage extends AbstractLevelUp {
    @Override
    public void levelUp() {
        knight.getWeapon().upPower(7);
        out.println
                ("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" +
                        knight.getWeapon().getPower());
        messageService.printHealthDefense();
        setLevelUp(true);
    }

    @Override
    protected void initComponent() {
        articular = 3;
        messageInMenu="Я несколько иначе ощущал свой меч, словно он стал моим продолжением";
    }
}
