package com.rhontproject.fabrics;

import com.rhontproject.attack.weapons.NormalSword;
import com.rhontproject.attack.Weapon;
import com.rhontproject.unit.Statless.NameStates;
import com.rhontproject.unit.Statless.StateHolder;
import org.springframework.context.annotation.*;

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
    public Weapon getKnightWeapon(){
        return new NormalSword(45);
    }

    @Bean
    @Scope("prototype")
    public Weapon getKnightFireWeapon(){
        return new NormalSword(45, NameStates.BURN);
    }


}
