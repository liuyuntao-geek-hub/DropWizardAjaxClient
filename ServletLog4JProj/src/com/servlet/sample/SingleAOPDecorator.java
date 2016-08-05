package com.servlet.sample;

import org.apache.log4j.Logger;

public class SingleAOPDecorator implements InventoryService
{
    private static Logger logger ;
    private DefaultInventoryService decorated;
    public SingleAOPDecorator()
    {
        super();
      decorated = new DefaultInventoryService();
        logger = Logger.getLogger(this.getClass());

    }

    public Inventory create(String vin, String name, Long id)
    {

      logger.info("before method: create"); 
      long start = System.nanoTime(); 

        Inventory inventory = decorated.create(vin, name, id);
        
      long end = System.nanoTime();
      logger.info(String.format("%s took %d ns", "create", (end-start)) );
        
        return inventory;
    }
    
    public static void main(String [] args)
    {
      Inventory inv = new SingleAOPDecorator().create("myvin", "myName", 1L);
      System.out.println("Current working Directory: "+System.getProperty("user.dir"));
      System.out.println(inv.getName());
    }
    
}
