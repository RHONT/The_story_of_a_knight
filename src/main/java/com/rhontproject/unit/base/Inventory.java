package com.rhontproject.unit.base;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
@Scope("prototype")
public class Inventory {
   private EnumMap<InventoryEnum,Integer> inventory=new EnumMap<>(InventoryEnum.class);

   public void add(InventoryEnum inventoryEnum,Integer amount){
      if (!inventory.containsKey(inventoryEnum)) {
         inventory.put(inventoryEnum, amount);
      } else {
         inventory.put(inventoryEnum,inventory.get(inventoryEnum)+amount);
      }
   }

   public Integer use(InventoryEnum inventoryEnum){
      Integer result = inventory.computeIfPresent(inventoryEnum, (k, v) -> v > 0 ? v - 1 : -1);
      if (result<0) {
         System.out.println("У вас нет " + inventoryEnum.getName());
      }
      return result;
   }

   public boolean contains(InventoryEnum inventoryEnum){
      return inventory.containsKey(inventoryEnum);
   }

   public Integer get(InventoryEnum inventoryEnum){
      return inventory.get(inventoryEnum);
   }


}
