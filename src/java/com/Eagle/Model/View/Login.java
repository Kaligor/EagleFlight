package com.Eagle.Model.View;

import com.Eagle.Admin.Logic;
import com.Eagle.Exceptions.UserException;
import com.Eagle.Model.Person;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Login
{

    @EJB
    Logic logic;

    Person person;

    String username;
    String password;

    String Status;

    public Login()
    {

    }

    public void logIn()
    {
        Status = "";
        if (person == null)
        {
        } else
        {
            try
            {
                person = logic.logIn(username, password);
                Status = "Success";
                cleanup();
            } catch (UserException e)
            {
                Status = e.getMessage();
                cleanup();
            }
        }
    }

    public void logOut()
    {
        if (person != null)
        {
            person = null;
            cleanup();
        }
    }

    public void cleanup()
    {
        username = "";
        password = "";
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Person getPerson()
    {
        return person;
    }
    
    public void setPerson(Person person)
    {
        this.person = person;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getStatus()
    {
        return Status;
    }
    
    public void setStatus(String Status)
    {
        this.Status = Status;
    }
//</editor-fold>

}
