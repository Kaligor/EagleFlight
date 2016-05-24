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
        logic.removePlane(id);
    }
}
