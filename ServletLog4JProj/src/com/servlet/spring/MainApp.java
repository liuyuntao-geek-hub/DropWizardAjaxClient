package com.servlet.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public MainApp()
    {
        super();
    }

    public static void main(String[] args)
    {
      ApplicationContext context = 
         new ClassPathXmlApplicationContext("Beans.xml");
      //new ClassPathXmlApplicationContext("E:\\java\\Beans.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

      (obj).getMessage();

    }
}
