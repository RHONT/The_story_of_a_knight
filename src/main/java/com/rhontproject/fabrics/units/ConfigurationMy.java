package com.rhontproject.fabrics.units;

import com.rhontproject.attack.weapons.NormalSword;
import com.rhontproject.attack.weapons.Weapon;
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
    public Weapon getKnightWeapon(){
        return new NormalSword(45);
    }

    @Bean
    @Scope("prototype")
    public Weapon getKnightFireWeapon(){
        return new NormalSword(45, NameStates.BURN);
    }


}
