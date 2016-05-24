package com.Eagle.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Person implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    private String username;

    public Person(String name, String username)
    {
        this.name = name;
        this.username = username;
    }

    public Person(String name)
    {
        this.name = name;
        this.username = generatedUsername();
    }

    public Person()
    {
    }
    
    private String generatedUsername()
    {
        return username = "Eagle" + id;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

//</editor-fold>
}
