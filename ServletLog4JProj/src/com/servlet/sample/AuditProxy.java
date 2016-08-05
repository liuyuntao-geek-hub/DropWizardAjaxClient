package com.servlet.sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.log4j.Logger;

public class AuditProxy implements InvocationHandler
{
    private static Logger logger ;
    private Object obj;
    

  public static Object newInstance(Object obj)
        { 
  return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AuditProxy(obj));
         }


  public AuditProxy(Object obj) 
  { 
    this.obj = obj; 
    logger = Logger.getLogger(this.getClass());
  } 

    
    public AuditProxy()
    {
        super();
    }

    public Object invoke(Object proxy, Method m,Object[] args) throws Throwable
    {
      Object result; 

      try { 

          logger.info("before method " + m.getName()); 
          long start = System.nanoTime(); 
          result = m.invoke(obj, args); 
          long end = System.nanoTime(); 
          logger.info(String.format("%s took %d ns", m.getName(), (end-start)) ); 
      } catch (InvocationTargetException e) { 

      throw e.getTargetException(); 

     } catch (Exception e) { 

            throw new RuntimeException("unexpected invocation exception: " + e.getMessage()); 
      } finally { 

       logger.info("after method " + m.getName()); 
      } 

      return result; 
    }
    
    
  public static void main(String [] args)
  {
  InventoryService invServ = (InventoryService) AuditProxy.newInstance(new DefaultInventoryService());

    Inventory inv = (invServ).create("myDynamicvin", "myDynamicName", 1L);

    System.out.println(invServ.getClass());
    System.out.println("Current working Directory: "+System.getProperty("user.dir"));
    System.out.println(inv.getName());
  
  }
  
}
