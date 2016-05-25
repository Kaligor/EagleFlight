package com.Eagle.Model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plane implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String callsign;

    @OneToMany
    private ArrayList<Seat> seats;

    //Available
    int nrOfFA;
    int nrOfEA;
    
    //Max
    int nrOfF;
    int nrOfE;

    int FIRSTCLASS = 0;
    int ECONOMYCLASS = 1;

    /**
     * Standard Constructor
     * @param callsign
     * @param nrOfF
     * @param nrOfE
     */
    public Plane(String callsign, int nrOfF, int nrOfE)
    {
        this.callsign = callsign;
        this.nrOfE = nrOfE;
        this.nrOfF = nrOfF;
        
        this.nrOfEA = this.nrOfE;
        this.nrOfFA = this.nrOfF;
    }

    /**
     * Default constructor for internal use only
     */
    public Plane()
    {
    }

    /**
     * Books a ticket if a seat of requested Rank is available
     * @param seat 
     */
    public void bookTicket(Seat seat)
    {
        if (seat.getRank() == FIRSTCLASS) 
        {
            if(getAvailableCheck(FIRSTCLASS)) {
                seats.add(seat);
            } else {
                System.out.println("First class is full");
            }
        } else if (seat.getRank() == ECONOMYCLASS) {
            if(getAvailableCheck(ECONOMYCLASS)) {
                seats.add(seat);
            } else {
                System.out.println("Economy Class is full");
            }
        }
    }

    /**
     * Checks if the requested Rank is available
     * @param rank
     * @return 
     */
    public boolean getAvailableCheck(int rank)
    {
        if (rank == FIRSTCLASS)
        {
            return nrOfFA > 0;
        } else if (rank == ECONOMYCLASS)
        {
            return nrOfEA > 0;
        } else
        {
            return false;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getCallsign()
    {
        return callsign;
    }

    public void setCallsign(String callsign)
    {
        this.callsign = callsign;
    }

    public ArrayList<Seat> getSeats()
    {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats)
    {
        this.seats = seats;
    }

    public int getNrOffF()
    {
        return nrOfF;
    }

    public void setNrOffF(int nrOffF)
    {
        this.nrOfF = nrOffF;
    }

    public int getNrOffE()
    {
        return nrOfE;
    }

    public void setNrOffE(int nrOffE)
    {
        this.nrOfE = nrOffE;
    }
//</editor-fold>
}