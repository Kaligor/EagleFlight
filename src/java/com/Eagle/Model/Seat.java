package com.Eagle.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Seat implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //0 First class 1 Economy class
    private int rank;
    
    @OneToOne
    private Person person;

    public Seat()
    {
    }

    public Seat(int rank)
    {
        this.rank = rank;
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
    
    public int getRank()
    {
        return rank;
    }
    
    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
//</editor-fold>
    
    
    
}
