package edu.ufp.afmiguez.tk.esof.airport.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
@Entity
public class Seat extends BaseModel{
    private String local;

    @OneToOne(fetch = FetchType.LAZY)
    private Passenger passenger;
}
