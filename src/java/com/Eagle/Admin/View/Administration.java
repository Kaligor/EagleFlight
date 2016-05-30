package com.Eagle.Admin.View;

import com.Eagle.Admin.ALogic;
import com.Eagle.Exceptions.UserException;
import com.Eagle.Model.Person;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Administration
{

    @EJB
    ALogic logic;

    Person person;

    String username;
    String name;

    String Status;

    public void findUser()
    {
        try
        {
            person = logic.findOneUser(username);
        } catch (UserException e)
        {
            Status = e.getMessage();
        }
    }

    public List<Person> getAllUsers()
    {
        return logic.getAllUser();
    }

    public void updateUser()
    {
        person.setUsername(username);
        person.setName(name);
    }

    public void deleteUser()
    {
        logic.removePerson(person);
    }

    public void resetPassword()
    {
        person.setPassword("1234");
    }

}
