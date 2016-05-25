package com.Eagle.Admin;

//Admin Logic
import com.Eagle.Model.Airport;
import com.Eagle.Model.Plane;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ALogic
{

    @PersistenceContext
    EntityManager em;

    public ALogic()
    {
    }

    public void persistAirplane(Plane plane)
    {
        em.persist(plane);
    }

    public void removePlane(Plane plane)
    {
        em.remove(plane);
    }

    public void persistAirport(Airport airport)
    {
        em.persist(airport);
    }
    
    public void removeAirport(Airport airport)
    {
        em.remove(airport);
    }

}
