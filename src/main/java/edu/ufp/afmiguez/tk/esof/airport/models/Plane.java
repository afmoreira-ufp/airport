package edu.ufp.afmiguez.tk.esof.airport.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Plane extends BaseModel{
    private String model;
    private String serialNumber;
    private int flightHours;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Flight> flights=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Seat> seats=new HashSet<>();

    public Plane(String model,String serialNumber) {
        this.setModel(model);
        this.setSerialNumber(serialNumber);
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
        flight.setPlane(this);
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

}
