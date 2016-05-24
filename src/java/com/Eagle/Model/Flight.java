package com.Eagle.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Flight implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String home;
    private String destination;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date takeoff;

    @OneToOne
    private Plane plane;

    private int payout;

    private int imageID;

    /** 
     * Default constructor for internal use only
     */
    public Flight()
    {
    }

    /**
     * Constructor for normal use
     * @param home
     * @param destination
     * @param plane
     * @param takeoff
     * @param imageID 
     */
    public Flight(String home, String destination, Plane plane, Date takeoff, int imageID)
    {
        this.home = home;
        this.destination = destination;
        this.plane = plane;
        this.takeoff = takeoff;
        this.imageID = imageID;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public int getImageID()
    {
        return imageID;
    }

    public void setImageID(int imageID)
    {
        this.imageID = imageID;
    }

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

    public Date getTakeoff()
    {
        return takeoff;
    }

    public void setTakeoff(Date takeoff)
    {
        this.takeoff = takeoff;
    }
//</editor-fold>

}
