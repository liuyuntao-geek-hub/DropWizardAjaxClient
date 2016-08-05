package com.servlet.sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestInvocationHandler implements InvocationHandler
{
    private Object testImpl;
    public TestInvocationHandler(Object impl)
    {
      this.testImpl = impl;
    }

    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable
    {
      if(Object.class  == method.getDeclaringClass()) {
             String name = method.getName();
             if("equals".equals(name)) 
             {
                 return proxy == args[0];
             } 
             else if("hashCode".equals(name)) 
             {
                 return System.identityHashCode(proxy);
             } 
             else if("toString".equals(name)) 
             {
                 return proxy.getClass().getName() + "@" +
                     Integer.toHexString(System.identityHashCode(proxy)) +
                     ", with InvocationHandler " + this;
             }
             else 
             {
                 throw new IllegalStateException(String.valueOf(method));
             }
         }
         return method.invoke(testImpl, args);

    }
    
  public static void main(String... args) {
     TestIf t = (TestIf) Proxy.newProxyInstance(TestIf.class.getClassLoader(),
                             new Class<?>[] {TestIf.class},
                             new TestInvocationHandler(new TestImpl()));
     System.out.printf("t.hello(Duke): %s%n", t.hello("Duke"));
     System.out.printf("t.toString(): %s%n", t);
     System.out.printf("t.hashCode(): %H%n", t);
     System.out.printf("t.equals(t): %B%n", t.equals(t));
     System.out.printf("t.equals(new Object()): %B%n", t.equals(new Object()));
     System.out.printf("t.equals(null): %B%n", t.equals(null));
  }

    
}
