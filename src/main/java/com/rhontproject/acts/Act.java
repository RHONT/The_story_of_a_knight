package com.rhontproject.acts;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.acts.actsaction.StateGame;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.rhontproject.fabrica.UnitFabric.*;

public abstract class Act {
    protected static final Scanner scanner=new Scanner(System.in);
    protected static final Unit knight= createKnight();
    public static final StateGame stateGame = new StateGame();
    public abstract void run();
}
