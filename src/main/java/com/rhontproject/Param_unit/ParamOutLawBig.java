package com.rhontproject.Param_unit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Создаю класс с параметром из файла properties
 * Затем его передаю юнитами (каталог: Actors)
 */

@Component("ParamOutLowBig")
@Scope("prototype")
public class ParamOutLawBig {
    @Value("${outlowbig}")
    public int[] array;
}