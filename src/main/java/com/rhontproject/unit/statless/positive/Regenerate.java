package com.rhontproject.unit.statless.positive;

import com.rhontproject.unit.Unit;
import com.rhontproject.unit.statless.AbstractState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.rhontproject.fabrics.global.GlobalVariable.messageService;

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
            for (int i = 0; i <= 3; i++) {
                unit.attribute.curHealth[i] += 100;
            }
            unit.stabilizeHealth();
            messageService.add(unit.getName() + " " + message);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    protected void initMessage() {
        message = " Восстановление!";
    }
}
