package com.rhontproject.param_unit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Создаю класс с параметром из файла properties
 * Затем его передаю юнитами (каталог: Actors)
 */

@Component("ParamZombie")
@Scope("prototype")
public class ParamZombie {
    @Value("${zombie}")
    public int[] array;
}
