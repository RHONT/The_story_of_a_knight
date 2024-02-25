package com.rhontproject.interfaceSupporFunctionHumanoid;

import com.rhontproject.abstractUnitParent.Humanoid;

public interface HumanoidSupportFunctional {
    void setHumanoid(Humanoid humanoid);

    void switch_for_level_up();

    void level_up();

    boolean isAlife();

    void print_health_info();

    void down_health();

    void reborn();

    void print_defense();

    void print_inv_and_money();

    void print_info_fight();

    void switch_for_halt();

    void halt();

    void setParam_humanoid(int[] param_humanoid);

}
