package com.Eagle.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Person implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @Column(unique = true)
    private String username;

    @OneToOne
    private Seat seat;

    /**
     * Normal registrated user
     * @param name
     * @param username 
     */
    public Person(String name, String username)
    {
        this.name = name;
        this.username = username;
    }

    /**
     * User without login
     * @param name 
     */
    public Person(String name)
    {
        this.name = name;
        this.username = generatedUsername();
    }

    /**
     * Default constructor for internal use only
     */
    public Person()
    {
    }

    /**
     * Generates usernames for people that do not want to login
     * @return Eagle+Id
     */
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

    public Seat getSeat()
    {
        return seat;
    }

    public void setSeat(Seat seat)
    {
        this.seat = seat;
    }
//</editor-fold>

}
