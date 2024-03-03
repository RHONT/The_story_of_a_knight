package com.rhontproject.fabrics;

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
    @Bean
    @Scope("prototype")
    public StateHolder getState(){
        return new StateHolder();
    }

    @Bean
    @Scope("prototype")
    public Weapon getClub(){
        return new NormalSword(11);
    }

    @Bean
    @Scope("prototype")
    public Weapon getBearPows(){
        return new NormalSword(90);
    }

    @Bean
    @Scope("prototype")
    public Weapon getDarkSword(){
        return new NormalSword(18,NameStates.POISON);
    }

    @Bean
    @Scope("prototype")
    public Weapon getKnightWeapon(){
        return new NormalSword(45);
    }

    @Bean
    @Scope("prototype")
    public Weapon getKnightFireWeapon(){
        return new NormalSword(45, NameStates.BURN);
    }

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


}
