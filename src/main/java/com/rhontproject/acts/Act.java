package com.rhontproject.acts;

import com.rhontproject.abstractUnitParent.Humanoid;
import com.rhontproject.stateMethods.StateGame;

import java.util.Scanner;

import static com.rhontproject.fabrica.UnitFabric.*;

public abstract class Act {
    protected static final Scanner scanner=new Scanner(System.in);
    protected static final Humanoid knight= createKnight();
    public static final StateGame stateGame = new StateGame();

    public abstract void run();


}
