package edu.ufp.afmiguez.tk.esof.airport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Pilot extends BaseModel {
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Company company;

    public Pilot(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pilot")
    private Set<Flight> flights=new HashSet<>();

    public void addFlight(Flight flight){
        this.flights.add(flight);
        flight.setPilot(this);
    }
}
