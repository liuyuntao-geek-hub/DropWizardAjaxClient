package com.servlet.sample;

public class Inventory
{
    private String name;
    private String vin;
    private Long id;
    private String make;
    public Inventory()
    {
        super();
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getVin()
    {
        return vin;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getMake()
    {
        return make;
    }
}
