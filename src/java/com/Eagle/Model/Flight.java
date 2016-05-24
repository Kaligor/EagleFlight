package com.Eagle.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Flight implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String home;
    private String destination;

    @OneToOne
    private Plane plane;

    private int payout;

    public Flight()
    {
    }

    public Flight(String home, String destination, Plane plane)
    {
        this.home = home;
        this.destination = destination;
        this.plane = plane;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getHome()
    {
        return home;
    }

    public void setHome(String home)
    {
        this.home = home;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public Plane getPlane()
    {
        return plane;
    }

    public void setPlane(Plane plane)
    {
        this.plane = plane;
    }

    public int getPayout()
    {
        return payout;
    }

    public void setPayout(int payout)
    {
        this.payout = payout;
    }
//</editor-fold>

}
