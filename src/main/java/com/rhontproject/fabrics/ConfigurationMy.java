package com.rhontproject.fabrics;

import com.rhontproject.service.events.levelup.AbstractLevelUp;
import com.rhontproject.service.events.levelup.levels.MoreChanceAttack;
import com.rhontproject.service.events.levelup.levels.MoreDamage;
import com.rhontproject.service.events.levelup.levels.MoreHealth;
import com.rhontproject.service.events.marketgoods.goods.Exit;
import com.rhontproject.service.events.marketgoods.MarketObject;
import com.rhontproject.service.events.marketgoods.goods.Molotov;
import com.rhontproject.service.events.marketgoods.goods.Potion;
import com.rhontproject.service.events.marketgoods.goods.StoneShield;
import com.rhontproject.unit.attack.weapons.NormalSword;
import com.rhontproject.unit.attack.weapons.Weapon;
import com.rhontproject.unit.statless.NameStates;
import com.rhontproject.unit.statless.StateHolder;
import org.springframework.context.annotation.*;

import java.util.*;

@org.springframework.context.annotation.Configuration
public class ConfigurationMy {
    /**
     * Объект находиться в каждом персонаже. По нему идет сверка на наличие у персонажа отрицательных штрафов
     * К примеру отравление/поджог. В начале каждого уровня персонаж получает урон, если в нем соответствующий state
     * @return
     */
    @Bean
    @Scope("prototype")
    public StateHolder getState(){
        return new StateHolder();
    }

    /**
     * Создаем оружие
     * @return
     */
    @Bean
    @Scope("prototype")
    public Weapon getClub(){
        return new NormalSword(11);
    }

    /**
     * Создаем оружие
     * @return
     */
    @Bean
    @Scope("prototype")
    public Weapon getBearPows(){
        return new NormalSword(90);
    }

    /**
     * Создаем оружие с отравлением
     * @return
     */
    @Bean
    @Scope("prototype")
    public Weapon getDarkSword(){
        return new NormalSword(18,NameStates.POISON);
    }

    /**
     * Создаем оружие
     * @return
     */
    @Bean
    @Scope("prototype")
    public Weapon getKnightWeapon(){
        return new NormalSword(45);
    }

    /**
     * Создаем оружие с поджогом
     * @return
     */
    @Bean
    @Scope("prototype")
    public Weapon getKnightFireWeapon(){
        return new NormalSword(45, NameStates.BURN);
    }

    /**
     * Добавляем в магазин предметы. LinkedHashSet нужен для запоминания порядка добавления.
     * @return
     */
    @Bean
    @Scope("singleton")
    public Set<MarketObject> marketObjets(){
        Set<MarketObject> sets=new LinkedHashSet<>();
        sets.add(new StoneShield());
        sets.add(new Potion());
        sets.add(new Molotov());
        sets.add(new Exit());
       return sets;
    }

    /**
     * Добавляем варианты повышения уровня LinkedHashSet нужен для запоминания порядка добавления
     * @return
     */
    @Bean
    @Scope("singleton")
    public Set<AbstractLevelUp> levelUps(){
        Set<AbstractLevelUp> sets=new LinkedHashSet<>();
        sets.add(new MoreHealth());
        sets.add(new MoreChanceAttack());
        sets.add(new MoreDamage());
        return sets;
    }


}
