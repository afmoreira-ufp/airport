package edu.ufp.afmiguez.tk.esof.airport.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Company extends BaseModel{
    @Column(unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Flight> flights=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company",fetch = FetchType.LAZY)
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
