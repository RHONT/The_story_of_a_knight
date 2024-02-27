package com.rhontproject.newarchitecture.state.negative;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.newarchitecture.state.AbstractState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope("prototype")
public class Burning extends AbstractState {
    {
        message=" Горение!";
    }
    @Override
    public void activate() {
        count += 3;
    }

    @Override
    public void disable() {
        count = 0;
    }

    @Override
    public void action(Unit unit) {
        if (count > 0) {

            count--;
            for (int i = 0; i <= 3; i++) {
                unit.baseAttribute.curHealth[i] -= 10;
            }
            unit.info_state += unit.name + " " + message;
        }
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
