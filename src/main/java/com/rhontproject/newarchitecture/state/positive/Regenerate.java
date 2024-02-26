package com.rhontproject.newarchitecture.state.positive;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.newarchitecture.state.AbstractState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope("prototype")
public class Regenerate extends AbstractState {

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
            Arrays.stream(unit.param_humanoid).forEach(e->e=e+10);
            unit.stabilizeHealth();
            unit.info_str_fight += unit.name + " " + message;
            unit.info_str_fight += Arrays.toString(unit.param_humanoid) +"\n";
        }
    }

    @Override
    public void setMessage() {
        message = " Восстановление!";
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
