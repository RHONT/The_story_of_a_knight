package com.rhontproject.unit;

import com.rhontproject.abstractUnitParent.NormalSword;
import com.rhontproject.abstractUnitParent.Weapon;
import com.rhontproject.newarchitecture.state.NameStates;
import com.rhontproject.newarchitecture.state.StateHolder;
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
