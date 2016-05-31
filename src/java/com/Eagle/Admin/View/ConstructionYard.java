package com.Eagle.Admin.View;

import com.Eagle.Admin.ALogic;
import com.Eagle.Model.Airport;
import com.Eagle.Model.Plane;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

@ManagedBean
@ViewScoped
public class ConstructionYard implements Serializable
{

    @EJB
    ALogic logic;

    long id;

    Airport airport;
    String name;
    String description = "";
    List<Plane> hangar;
    Plane plane;
    List<Airport> list;

    @PostConstruct
    public void init()
    {
        list = logic.refreshAllAirports();
        hangar = logic.refreshAllPlanes();
    }

    public void buildAirport()
    {
        logic.persistAirport(new Airport(name, hangar, description));
        refreshList();
    }

    public void removeAirport()
    {
        logic.removeAirport(airport);
        refreshList();
    }

    public void editAirport(int index)
    {
        logic.updateAirport(list.get(index));
        refreshList();
    }

    public void onCellEdit(CellEditEvent event)
    {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue))
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);

            editAirport(event.getRowIndex());
        }
    }

    public void refreshList()
    {
        list = logic.refreshAllAirports();
        hangar = logic.refreshAllPlanes();
    }

    public void addPlane(int index)
    {
        hangar.add(hangar.get(index));

    }

    public void removePlane()
    {
        hangar.remove(plane);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public List<Plane> getAllPlanes()
    {
        return hangar;
    }

    public List<Airport> getAllAirports()
    {
        return logic.refreshAllAirports();
    }

    public List<Airport> getList()
    {
        return list;
    }

    public void setList(List<Airport> list)
    {
        this.list = list;
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
