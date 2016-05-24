package com.Eagle.Admin;

//Admin Logic
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

    public void removePlane(long id)
    {
//        em.getTransaction().begin();
        em.remove(em.find(Plane.class, id));
//        em.getTransaction().commit();

    }

}
