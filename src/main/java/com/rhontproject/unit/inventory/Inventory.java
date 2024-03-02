package com.rhontproject.unit.inventory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
@Scope("prototype")
public class Inventory {
   private final EnumMap<InventoryEnum,Integer> inventory=new EnumMap<>(InventoryEnum.class);

   public void add(InventoryEnum inventoryEnum,Integer amount){
      if (!inventory.containsKey(inventoryEnum)) {
         inventory.put(inventoryEnum, amount);
      } else {
         inventory.put(inventoryEnum,inventory.get(inventoryEnum)+amount);
      }
   }

   public void use(InventoryEnum inventoryEnum){
      inventory.computeIfPresent(inventoryEnum, (k, v) -> v > 0 ? v - 1 : -1);
   }

   public boolean contains(InventoryEnum inventoryEnum){
      return inventory.containsKey(inventoryEnum);
   }

   public Integer get(InventoryEnum inventoryEnum){
      return inventory.get(inventoryEnum);
   }

   public void clearInventory(){
      inventory.clear();
   }


}
