package com.rhontproject.unit;

import com.rhontproject.newarchitecture.state.StateHolder;
import org.springframework.context.annotation.*;

@org.springframework.context.annotation.Configuration
public class ConfigurationMy {
    @Bean
    @Scope("prototype")
    public StateHolder getState(){
        return new StateHolder();

    }


}
