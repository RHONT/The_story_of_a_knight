package com.rhontproject.fabrics;

import com.rhontproject.fabrics.units.*;
import com.rhontproject.unit.Unit;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * Достаем заготовленных персонажей и если нужно дополнительно их конфигурируем.
 */
public final class UnitFabric {
    private static final Random random=new Random();
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
        zombie.attribute.setDefense(rnd(10), rnd(20), rnd(10), rnd(5));
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

    public static int rnd(int maxValue){
        return random.nextInt(maxValue);
    }
}
