package com.Eagle.Admin.View;

import com.Eagle.Admin.ALogic;
import com.Eagle.Exceptions.UserException;
import com.Eagle.Model.Person;
import com.Eagle.Model.Plane;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@ViewScoped
public class Administration
{

    @EJB
    ALogic logic;

    Person person;

    String username;
    String name;

    String Status;

    List<Person> allUsers;

    public void init()
    {
        allUsers = logic.getAllUser();
    }

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

    public void updateUser(int index)
    {
        logic.updatePerson(allUsers.get(index));
    }

    public void deleteUser()
    {
        logic.removePerson(person);
    }

    public void resetPassword()
    {
        person.setPassword("1234");
    }
    
    public void onRowEdit(RowEditEvent event)
    {
        FacesMessage msg = new FacesMessage("Plane has been updated", ((Plane) event.getObject()).getCallsign());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event)
    {

        FacesMessage msg = new FacesMessage("Update Cancelled", ((Plane) event.getObject()).getCallsign());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event)
    {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue))
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);

            updateUser(event.getRowIndex());

        }
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
