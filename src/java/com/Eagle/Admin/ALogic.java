package com.Eagle.Admin;

//Admin Logic
import com.Eagle.Exceptions.UserException;
import com.Eagle.Model.Airport;
import com.Eagle.Model.Flight;
import com.Eagle.Model.Person;
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
    List<Airport> allAirports;
    List<Flight> allFlights;

    public ALogic()
    {
        allPlanes = new ArrayList<>();
        allAirports = new ArrayList<>();
        allFlights = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Hangar">
    public void persistAirplane(Plane plane)
    {
        em.persist(plane);
    }

    public void updatePlane(Plane newPlane)
    {
        em.merge(newPlane);
    }

    public Plane getOnePlane(Long id)
    {
        return em.find(Plane.class, id);
    }

    public List<Plane> refreshAllPlanes()
    {
        Query query = em.createNativeQuery("SELECT * FROM plane", Plane.class);
        allPlanes = query.getResultList();
        return allPlanes;
    }

    
    public void removePlane(Plane plane)
    {
        if (plane != null)
        {

            em.remove(em.find(Plane.class, plane.getId()));
        }
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construction Yard">
    public void persistAirport(Airport airport)
    {
        em.persist(airport);
    }
    
    public void updateAirport(Airport newAirport)
    {
        em.merge(newAirport);
    }    

    public void removeAirport(Airport airport)
    {
        em.remove(airport);
    }

    public List<Airport> refreshAllAirports()
    {
        Query query = em.createNativeQuery("SELECT * FROM airport", Airport.class);
        allAirports = query.getResultList();
        return allAirports;
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
    
    public List<Flight> refreshAllFlights() 
    {
        Query query = em.createNativeQuery("SELECT * FROM fligth", Flight.class);
        allFlights = query.getResultList();
        return allFlights;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Administration">
    public void persistPerson(Person person)
    {
        em.persist(person);
    }
    
    public void updatePerson(Person person)
    {
        em.merge(person);
    }

    public Person findOneUser(String username) throws UserException
    {
        Query query = em.createNativeQuery("SELECT * FROM person WHERE = '" + username + "'", Person.class);
        List<Person> list = query.getResultList();
        if (!list.isEmpty())
        {
            return list.get(0);
        } else
        {
            throw new UserException("No such User");
        }
    }

    public List<Person> getAllUser()
    {
        Query query = em.createNativeQuery("SELECT * FROM person", Person.class);
        List<Person> list = query.getResultList();
        return list;
    }

    public void removePerson(Person person)
    {
        em.remove(person);
    }
//</editor-fold>

}
