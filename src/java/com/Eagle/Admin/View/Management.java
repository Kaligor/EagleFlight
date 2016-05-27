package com.Eagle.Admin.View;

import com.Eagle.Admin.ALogic;
import com.Eagle.Model.Flight;
import com.Eagle.Model.Plane;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Management 
{
    
    @EJB
    ALogic logic;
    
    Flight flight;

    String home;
    String destination;
    
    Date takeoff;
    
    Plane plane;
    
    int payout;
    
    int imageID;
    
    public void createFlight() 
    {
        logic.persistFlight(new Flight(home, destination, plane, takeoff, imageID));
    }
    
    public void removeFlight() 
    {
        logic.removeFlight(flight);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Flight getFlight()
    {
        return flight;
    }
    
    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }
    
    public String getHome()
    {
        return home;
    }
    
    public void setHome(String home)
    {
        this.home = home;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    public Date getTakeoff()
    {
        return takeoff;
    }
    
    public void setTakeoff(Date takeoff)
    {
        this.takeoff = takeoff;
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
    
    public int getImageID()
    {
        return imageID;
    }
    
    public void setImageID(int imageID)
    {
        this.imageID = imageID;
    }
//</editor-fold>
    
    
}
