package com.rhontproject.param_unit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Создаю класс с параметром из файла properties
 * Затем его передаю юнитами (каталог: Actors)
 */

@Component("ParamOutLawBridge")
@Scope("prototype")
public class ParamOutLawBridge {
    @Value("${outlowbridge}")
    public int[] array;
}