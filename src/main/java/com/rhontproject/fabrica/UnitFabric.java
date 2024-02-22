package com.rhontproject.fabrica;

import com.rhontproject.abstractUnitParent.Humanoid;
import com.rhontproject.unit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public final class UnitFabric {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UnitFabric() {
    }

    public static Humanoid createKnight(){
        Knight knight = context.getBean("Knight", Knight.class);
        knight.setDefense(30, 30, 30, 30);
        return knight;
    }

    public static Humanoid createZombie(){
        Zombie zombie = context.getBean("Zombie", Zombie.class);
        zombie.setDefense(random(10), random(20), random(10), random(5));
        return zombie;
    }

    public static Humanoid createOutLowBig(){
        return context.getBean("OutLowBig", OutLowBig.class);
    }

    public static Humanoid createOutLowSmall(){
        return context.getBean("OutLowSmall", OutLowSmall.class);
    }

    public static Humanoid createBear(){
        return context.getBean("Bear", Bear.class);
    }

    public static Humanoid createOutLowBridge(){
        return context.getBean("OutLowBridge", OutLawBridge.class);
    }

    public static Humanoid createKnightDark(){
        return context.getBean("Knight_In_The_Dark", Knight_In_The_Dark.class);
    }

    private static int random(int maxValue){
        return new Random().nextInt(maxValue);
    }

}
