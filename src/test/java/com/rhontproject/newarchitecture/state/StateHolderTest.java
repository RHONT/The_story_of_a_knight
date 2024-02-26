package com.rhontproject.newarchitecture.state;

import com.rhontproject.abstractUnitParent.Unit;
import com.rhontproject.fabrica.UnitFabric;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.rhontproject.newarchitecture.state.NameStates.*;

class StateHolderTest {

    @Test
    void activate() {
        Unit knight = UnitFabric.createKnight();
        knight.getStateHolder().activeSelectState(BURN);
        knight.getStateHolder().activate();
        knight.getStateHolder().activate();
        knight.getStateHolder().activeSelectState(REGENERATE);
        knight.getStateHolder().activate();

        knight.getStateHolder().activate();
    }

    @Test
    void findClassName(){
        Integer i=5;
        String g="sdf";
        List<Object> list=new ArrayList<>(List.of(i,g));
        System.out.println(i.getClass().getSimpleName());
    }
}