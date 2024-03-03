package com.rhontproject.unit.inventory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
@Scope("prototype")
public class Inventory {
   private final EnumMap<InventoryEnum,Integer> inventoryMap =new EnumMap<>(InventoryEnum.class);

   public void add(InventoryEnum inventoryEnum,Integer amount){
      if (!inventoryMap.containsKey(inventoryEnum)) {
         inventoryMap.put(inventoryEnum, amount);
      } else {
         inventoryMap.put(inventoryEnum, inventoryMap.get(inventoryEnum)+amount);
      }
   }

   public void use(InventoryEnum inventoryEnum){
      inventoryMap.computeIfPresent(inventoryEnum, (k, v) -> v > 0 ? v - 1 : -1);
   }

   public boolean contains(InventoryEnum inventoryEnum){
      return inventoryMap.containsKey(inventoryEnum);
   }

   public Integer get(InventoryEnum inventoryEnum){
      return inventoryMap.get(inventoryEnum);
   }

   public void clearInventory(){
      inventoryMap.clear();
   }


}
