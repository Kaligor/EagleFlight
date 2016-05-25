package com.Eagle.Admin;

//Admin Logic
import com.Eagle.Model.Airport;
import com.Eagle.Model.Plane;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    
    public List<Plane> getAllPlanes() 
    {
        Query query = em.createNamedQuery("SELECT * FROM Plane", Plane.class);
        List<Plane> list = query.getResultList();
        return list;
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
