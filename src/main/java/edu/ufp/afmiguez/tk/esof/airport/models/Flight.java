package edu.ufp.afmiguez.tk.esof.airport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Flight extends BaseModel {

    private LocalDate date;

    private String flightNumber;
    @OneToOne
    private Airport departure;
    @OneToOne
    private Airport arrival;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Pilot pilot;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Plane plane;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Passenger> passengers=new HashSet<>();

    public Flight(LocalDate date, String flightNumber) {
        this.setDate(date);
        this.setFlightNumber(flightNumber);
    }

}
