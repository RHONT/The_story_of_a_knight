package com.rhontproject.acts;

import com.rhontproject.service.EventKnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public abstract class Act {
    @Autowired
    protected EventKnightService eventKnightService;
    protected static final Scanner scanner=new Scanner(System.in);

    public abstract void run();
}
