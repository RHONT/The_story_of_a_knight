package com.rhontproject.unit.statless;

import com.rhontproject.unit.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class StateHolder {
    private Unit unit;
    private List<String> listNameState;

    @Autowired
    List<StateAction> stateActionList;

    public void activate(){
        stateActionList.forEach(e->e.action(unit));
    }

    public void activeSelectState(NameStates nameStates){
        if (listNameState==null) {
            listNameState=stateActionList.stream().
                    map(e->e.getClass().getSimpleName()).
                    collect(Collectors.toList());
        }
        if (listNameState.contains(nameStates.getNameClass())) {
            stateActionList.stream().
                    filter(e->e.getClass().getSimpleName().equals(nameStates.getNameClass())).
                    findFirst().
                    get().
                    activate();
        }

    }


    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
