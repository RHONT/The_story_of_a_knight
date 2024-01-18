package com.rhontproject.param_unit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Создаю класс с параметром из файла properties
 * Затем его передаю юнитами (каталог: Actors)
 */

@Component("ParamOutLowSmall")
@Scope("prototype")
public class ParamOutLowSmall {
    @Value("${outlowsmall}")
    public int[] array;
}


