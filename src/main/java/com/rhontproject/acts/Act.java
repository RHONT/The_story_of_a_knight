package com.rhontproject.acts;

import com.rhontproject.service.EventKnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Каждый акт - отдельный набор событий
 * scanner - отвечает за переход к новому акту по нажатию на Enter
 * eventKnightService - сервис с заготовленными сценариями по разным событиям. Битва/магазин/привал/повышение уровня
 */
@Component
public abstract class Act {
    @Autowired
    protected EventKnightService eventKnightService;
    protected static final Scanner scanner=new Scanner(System.in);

    public abstract void run();
}
