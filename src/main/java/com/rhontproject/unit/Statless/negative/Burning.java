package com.rhontproject.unit.Statless.negative;

import com.rhontproject.unit.Statless.AbstractState;
import com.rhontproject.unit.Unit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
                unit.attribute.curHealth[i] -= 10;
            }
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
