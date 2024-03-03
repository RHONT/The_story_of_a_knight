package com.rhontproject.unit.statless.negative;

import com.rhontproject.unit.statless.AbstractState;
import com.rhontproject.unit.Unit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;

@Component
@Scope("prototype")
public class Burning extends AbstractState {

    @Override
    protected void initMessage() {
        message = " Горит!";
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
            messageService.add(unit.getName() + " " + message);
        }
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
