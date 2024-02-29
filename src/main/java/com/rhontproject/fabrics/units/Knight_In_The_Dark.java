package com.rhontproject.fabrics.units;

import com.rhontproject.unit.base.BaseAttribute;
import com.rhontproject.attack.Attack;
import com.rhontproject.unit.Statless.StateHolder;
import com.rhontproject.unit.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Knight_In_The_Dark")
@Scope("prototype")
public
class Knight_In_The_Dark extends Unit {

    public Knight_In_The_Dark(
            @Qualifier("standardAttack") Attack attack,
            StateHolder stateHolder,
            BaseAttribute baseAttribute) {
        super(stateHolder, baseAttribute, attack);
        this.name = "Скелет во тьме";
    }

    @Autowired
    @Override
    public void setHealth(@Value("${knight_in_the_dark}") int[] health) {
        this.attribute.setCurHealth(health);
    }
}
