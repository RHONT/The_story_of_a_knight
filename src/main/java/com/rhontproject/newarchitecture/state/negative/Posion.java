package com.rhontproject.newarchitecture.state.negative;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.newarchitecture.state.AbstractState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope("prototype")
public class Posion extends AbstractState {
    {
        message=" Отравление!";
    }
    @Override
    public void activate() {
        count += 2;
    }

    @Override
    public void disable() {
        count = 0;
    }

    @Override
    public void action(Unit unit) {
        if (count > 0) {
            count--;
            Arrays.stream(unit.attribute.curHealth).forEach(e->e=e-10);
            messageService.add(unit.name + " " + message);
        }
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
