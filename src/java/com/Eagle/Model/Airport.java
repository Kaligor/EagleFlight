package com.Eagle.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
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

    @OneToMany
    List<Plane> hangar;

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
        this.hangar = hangar;
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
        this.hangar = hangar;
        this.description = description;
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
    
    public List<Plane> getHangar()
    {
        return hangar;
    }
    
    public void setHangar(ArrayList<Plane> hangar)
    {
        this.hangar = hangar;
    }
//</editor-fold>

}
