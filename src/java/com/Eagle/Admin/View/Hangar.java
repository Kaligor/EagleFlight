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
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@ViewScoped
public class Hangar implements Serializable
{

    @EJB
    ALogic logic;

    Plane plane;

    long id;
    String callsign;

    int nrOfF;
    int nrOfE;

    //TODO: change from getList to local list
    List<Plane> list;
    List<Airport> allAirports;

    @PostConstruct
    public void init()
    {
        list = logic.refreshAllPlanes();
        allAirports = logic.refreshAllAirports();
    }

    public void newPlane()
    {
        logic.persistAirplane(new Plane(callsign, nrOfF, nrOfE));
        refreshList();
        //TODO: add refresh List here
    }

    public void editPlane(int index)
    {
        logic.updatePlane(list.get(index));
        refreshList();
    }

    public void removePlane(int index)
    {

        logic.removePlane(list.get(index - 1));
        refreshList();
    }

    public void findPlane(long index)
    {
        plane = logic.findOnePlane(index);
    }

    public void getAllAvailableAirports()
    {
        allAirports = logic.refreshAllAirports();
    }

    public void onRowEdit(RowEditEvent event)
    {
        FacesMessage msg = new FacesMessage("Plane has been updated", ((Plane) event.getObject()).getCallsign());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event)
    {

        FacesMessage msg = new FacesMessage("Update Cancelled", ((Plane) event.getObject()).getCallsign());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event)
    {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue))
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);

            editPlane(event.getRowIndex());

        }
    }

//    public void onRowSelect(SelectEvent event)
//    {
//        FacesMessage msg = new FacesMessage("Plane Selected", ((Plane) event.getObject()).getCallsign());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//
//    public void onRowUnselect(UnselectEvent event)
//    {
//        FacesMessage msg = new FacesMessage("Plane Unselected", ((Plane) event.getObject()).getCallsign());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    public void refreshList()
    {
        list = logic.refreshAllPlanes();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public List<Airport> getAllAirports()
    {
        return allAirports = logic.refreshAllAirports();
    }

    public void setAllAirports(List<Airport> allAirports)
    {
        this.allAirports = allAirports;
    }

    public List<Plane> getList()
    {
        return list;
    }

    public void setList(List<Plane> list)
    {
        this.list = list;
    }

    public Plane getPlane()
    {
        return plane;
    }

    public void setPlane(Plane plane)
    {
        this.plane = plane;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getCallsign()
    {
        return callsign;
    }

    public void setCallsign(String callsign)
    {
        this.callsign = callsign;
    }

    public int getNrOfF()
    {
        return nrOfF;
    }

    public void setNrOfF(int nrOfF)
    {
        this.nrOfF = nrOfF;
    }

    public int getNrOfE()
    {
        return nrOfE;
    }

    public void setNrOfE(int nrOfE)
    {
        this.nrOfE = nrOfE;
    }
//</editor-fold>

}
