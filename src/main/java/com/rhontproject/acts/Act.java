package com.rhontproject.acts;

import com.rhontproject.service.events.FightArea;
import com.rhontproject.service.EventKnightService;
import com.rhontproject.fabrics.global.StateGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public abstract class Act {
    @Autowired
    protected EventKnightService eventKnightService;

    @Autowired
    protected StateGame stateGame;

    protected static final Scanner scanner=new Scanner(System.in);
    public abstract void run();
}
