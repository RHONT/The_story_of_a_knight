package com.rhontproject.acts;

import com.rhontproject.abstractUnitParent.Humanoid;
import com.rhontproject.fabrica.UnitFabric;

import java.util.Scanner;

import static com.rhontproject.fabrica.UnitFabric.*;

public abstract class ActParent {
    protected static final Scanner scanner=new Scanner(System.in);
    protected static final Humanoid knight= createKnight();

    public abstract void run();


}
