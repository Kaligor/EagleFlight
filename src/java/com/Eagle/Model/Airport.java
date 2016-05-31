package com.Eagle.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airport implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;

    @OneToMany(mappedBy = "homebase", fetch = FetchType.EAGER)
    List<Plane> planes;

    private String description;

    /**
     * Default constructor for internal use only
     */
    public Airport()
    {
    }

    /**
     * Standard Constructor
     *
     * @param name
     * @param hangar
     */
    public Airport(String name, ArrayList<Plane> hangar)
    {
        this.name = name;
        this.planes = hangar;
    }

    /**
     * Standard Constructor, with Description
     *
     * @param name
     * @param hangar
     * @param description
     */
    public Airport(String name, List<Plane> hangar, String description)
    {
        this.name = name;
        this.planes = hangar;
        this.description = description;
    }

    public String printPlanes()
    {
        String returnValue = "";

        for (Plane item : planes)
        {
            returnValue += item.getCallsign() + " \n";
        }

        return returnValue;
    }

//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public long getId()
    {
        return Id;
    }

    public void setId(long Id)
    {
        this.Id = Id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Plane> getPlanes()
    {
        return planes;
    }

    public void setPlanes(ArrayList<Plane> hangar)
    {
        this.planes = hangar;
    }
//</editor-fold>

    @Override
    public String toString()
    {
        return "Airport{" + "Id=" + Id + ", name=" + name + ", hangar=" + planes + ", description=" + description + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 67 * hash + (int) (this.Id ^ (this.Id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Airport other = (Airport) obj;
        if (this.Id != other.Id)
        {
            return false;
        }
        return true;
    }

}
