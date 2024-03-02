package com.rhontproject.fabrics;

import com.rhontproject.fabrics.units.*;
import com.rhontproject.unit.Unit;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public final class UnitFabric {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private UnitFabric() {
    }

    public static Unit createKnight(){
        Knight knight = context.getBean("Knight", Knight.class);
        knight.attribute.setDefense(30, 30, 30, 30);
        return knight;
    }

    public static Unit createZombie(){
        Zombie zombie = context.getBean("Zombie", Zombie.class);
        zombie.attribute.setDefense(random(10), random(20), random(10), random(5));
        return zombie;
    }

    public static Unit createOutLowBig(){
        return context.getBean("OutLowBig", OutLowBig.class);
    }

    public static Unit createOutLowSmall(){
        return context.getBean("OutLowSmall", OutLowSmall.class);
    }

    public static Unit createBear(){
        return context.getBean("Bear", Bear.class);
    }

    public static Unit createOutLowBridge(){
        return context.getBean("OutLowBridge", OutLawBridge.class);
    }

    public static Unit createKnightDark(){
        return context.getBean("Knight_In_The_Dark", Knight_In_The_Dark.class);
    }

    private static int random(int maxValue){
        return new Random().nextInt(maxValue);
    }

}
