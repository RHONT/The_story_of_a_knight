//package com.rhontproject.unit;
//
//import com.rhontproject.abstractUnitParent.BaseAttribute;
//import com.rhontproject.attack.Attack;
//import com.rhontproject.Statless.StateHolder;
//import com.rhontproject.supports.basemechanics.UnitBaseFunctional;
//import com.rhontproject.abstractUnitParent.Unit;
//import com.rhontproject.supports.outputinfo.Printable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//@Component("OutLowBridge")
//@Scope("prototype")
//public
//class OutLawBridge extends Unit {
//
//    public OutLawBridge(@Qualifier("enemyAttackImpl") Attack attack,
//                @Qualifier("unitStandardBaseImpl") UnitBaseFunctional unitBaseFunctional,
//                @Qualifier("printImpl") Printable printable, StateHolder stateHolder, BaseAttribute baseAttribute) {
//        super(stateHolder, isHero, baseAttribute, attack, unitBaseFunctional, printable);
//        this.name = "Разбойник";
//
//    }
//
//    @Override
//    public void setUnit(Unit unit) {
//
//    }
//
//    @Autowired
//    @Override
//    public void setHealth(@Value("${outlowbridge}") int[] health) {
//        this.attribute.setCurHealth(health);
//    }
//}