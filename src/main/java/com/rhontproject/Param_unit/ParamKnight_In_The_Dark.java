package com.rhontproject.Param_unit;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Создаю класс с параметром из файла properties
 * Затем его передаю юнитами (каталог: Actors)
 */

@Component("ParamKnight_In_The_Dark")
@Scope("prototype")
public class ParamKnight_In_The_Dark {
    @Value("${knight_in_the_dark}")
    public int[] array;
}
