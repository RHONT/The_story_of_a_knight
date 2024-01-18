package com.rhontproject.InterfaceSupporFunctionHumanoid;

import com.rhontproject.AbstractUnitParent.Humanoid;

public interface HumanoidSupportFunctional {
    void setHumanoid(Humanoid humanoid);

    void swith_for_level_up();

    void level_up();

    boolean Humanoid_is_alife();

    void print_health_info();

    void down_health();

    void reborn();

    void print_defense();

    void print_inv_and_money();

    void print_info_fight();

    void swith_for_halt();

    void halt();

}
