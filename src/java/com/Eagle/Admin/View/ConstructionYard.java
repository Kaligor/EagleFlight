package com.Eagle.Admin.View;

import com.Eagle.Admin.ALogic;
import com.Eagle.Model.Airport;
import com.Eagle.Model.Plane;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ConstructionYard
{

    @EJB
    ALogic logic;

    long id;

    Airport airport;
    String name;
    String description = "";
    List<Plane> hangar = new ArrayList();
    Plane plane;
    List<Plane> allPlanes;

    public void buildAirport()
    {
        logic.persistAirport(new Airport(description, hangar, description));
    }

    public void removeAirport()
    {
        logic.removeAirport(airport);
    }

    public void addPlane()
    {
        hangar.add(plane);
    }

    public void removePlane()
    {
        hangar.remove(plane);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public List<Plane> getAllPlanes()
    {
        return allPlanes;
    }

    public Airport getAirport()
    {
        return airport;
    }

    public void setAirport(Airport airport)
    {
        this.airport = airport;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Plane getPlane()
    {
        return plane;
    }

    public void setPlane(Plane plane)
    {
        this.plane = plane;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
//</editor-fold>
}
