package com.Eagle.Admin.View;

import com.Eagle.Admin.ALogic;
import com.Eagle.Model.Plane;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Hangar
{

    @EJB
    ALogic logic;

    Plane plane;

    long id;
    String callsign;

    int nrOfF;
    int nrOfE;

    public void newPlane()
    {
        logic.persistAirplane(new Plane(callsign, nrOfF, nrOfE));
    }

    public void editPlane()
    {

    }

    public void removePlane()
    {
        logic.removePlane(plane);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Plane getPlane()
    {
        return plane;
    }

    public void setPlane(Plane plane)
    {
        this.plane = plane;
    }

    public ALogic getLogic()
    {
        return logic;
    }

    public void setLogic(ALogic logic)
    {
        this.logic = logic;
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
