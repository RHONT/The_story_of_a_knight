package com.rhontproject.unit.Statless.negative;

import com.rhontproject.unit.Unit;
import com.rhontproject.unit.Statless.AbstractState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;

@Component
@Scope("prototype")
public class Posion extends AbstractState {
    {
        message=" Отравление!";
    }
    @Override
    public void activate() {
        count += 10;
    }

    @Override
    public void disable() {
        count = 0;
    }

    @Override
    public void action(Unit unit) {
        if (count > 0) {
            count--;
            unit.attribute.curHealth=Arrays.stream(unit.attribute.curHealth).map(e->e-4).toArray();
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
