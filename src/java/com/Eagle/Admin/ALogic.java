package com.Eagle.Admin;

//Admin Logic
import com.Eagle.Model.Airport;
import com.Eagle.Model.Flight;
import com.Eagle.Model.Plane;
import java.util.ArrayList;
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

    List<Plane> allPlanes;

    public ALogic()
    {
        allPlanes = new ArrayList<>();

    }

    //<editor-fold defaultstate="collapsed" desc="Hangar">
    public void persistAirplane(Plane plane)
    {
        em.persist(plane);
    }

    public Plane getOnePlane(Long id)
    {
        return em.find(Plane.class, id);
    }

    public List<Plane> getAllPlanes()
    {
        Query query = em.createNativeQuery("SELECT * FROM plane", Plane.class);
        allPlanes = query.getResultList();
        return allPlanes;
    }

    public void removePlane(Plane plane)
    {
        if (plane != null)
        {
            em.remove(plane);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construction Yard">
    public void persistAirport(Airport airport)
    {
        em.persist(airport);
    }

    public void removeAirport(Airport airport)
    {
        em.remove(airport);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Management">
    public void persistFlight(Flight flight)
    {
        em.persist(flight);
    }

    public void removeFlight(Flight flight)
    {
        em.remove(flight);
    }
//</editor-fold>

}
