package com.rhontproject.service.events.levelup.levels;

import com.rhontproject.service.events.levelup.AbstractLevelUp;

import static com.rhontproject.fabrics.global.GlobalVariable.knight;
import static com.rhontproject.fabrics.global.StateGame.setLevelUp;
import static java.lang.System.out;

public class MoreChanceAttack extends AbstractLevelUp {
    @Override
    public void levelUp() {
        knight.plusChanceAttack(5);
        out.println
                ("Ваша базовая меткость увеличилась на 5 единиц, теперь она составляет:" +
                        knight.getChanceAttack());
        setLevelUp(true);
    }

    @Override
    protected void initComponent() {
        articular = 2;
        messageInMenu="А ведь не так быстро двигался враг, был момент даже когда мне показалось, что время замедлилось.";
    }
}
