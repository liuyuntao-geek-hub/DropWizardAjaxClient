package com.servlet.sample;

public class TestImpl implements TestIf
{
    public TestImpl()
    {
        super();
    }

    public String hello(String name)
    {
      return String.format("Hello %s, this is %s", name, this);
    }
}
