package com.Eagle.Admin;

//User Logic
import com.Eagle.Exceptions.UserException;
import com.Eagle.Model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class Logic
{

    @PersistenceContext
    EntityManager em;

    public Logic()
    {

    }

    public void persistUser(Person person)
    {
        em.persist(person);
    }

    public void removeUSer(Person person)
    {
        em.remove(person);
    }

    public boolean validateUser(String username)
    {
        Query query = em.createNativeQuery("SELECT * FROM person WHERE username = '" + username + "'", Person.class);
        List<Person> list = query.getResultList();
        return list.isEmpty();
    }

    public Person logIn(String username, String password) throws UserException
    {
        Query query = em.createNativeQuery("SELECT * FROM person WHERE username = '" + username + "'", Person.class);
        List<Person> list = (ArrayList) query.getResultList();
        if (!list.isEmpty())
        {
            Person person = list.get(0);
            if (person.getPassword().equals(password))
            {
                return person;
            } else
            {
                throw new UserException("Incorrect Password");
            }
        } else
        {
            throw new UserException("No Such User");
        }
    }

}
