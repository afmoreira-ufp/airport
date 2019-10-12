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
public class Company extends BaseModel{
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Flight> flights=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pilot> pilots=new HashSet<>();

    public Company(String name) {
        this.setName(name);
    }

    public void addFlight(Flight flight){

        this.flights.add(flight);
        flight.setCompany(this);
    }

    public void addPilot(Pilot pilot){
        this.pilots.add(pilot);
        pilot.setCompany(this);
    }
}
