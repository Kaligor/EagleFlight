package com.Eagle.Model.View;

import com.Eagle.Admin.Logic;
import com.Eagle.Model.Person;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class newUser
{

    @EJB
    Logic logic;

    String username;
    String password;
    String name;

    String Status;

    public void newUser()
    {
        Status = "";
        if (logic.validateUser(username))
        {
            logic.persistUser(new Person(name, username, password));
            cleanup();
        } else
        {
            Status = "A User with that Name already exists";
            cleanup();
        }
    }

    public void cleanup()
    {
        username = "";
        password = "";
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
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
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
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
