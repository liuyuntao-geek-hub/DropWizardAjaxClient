package com.servlet.sample;

public class DefaultInventoryService implements InventoryService
{
    public DefaultInventoryService()
    {
     //   super();
    }

    public Inventory create(String vin, String name, Long id)
    {
        Inventory inventory = new Inventory();
        inventory.setId(id);
        inventory.setMake("Default");
        inventory.setName(name);
        inventory.setVin(vin);
        return inventory;
    }
}
