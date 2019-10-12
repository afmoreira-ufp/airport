package edu.ufp.afmiguez.tk.esof.airport.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Passenger extends BaseModel{
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Flight flight;
    @OneToOne(fetch = FetchType.LAZY)
    private Seat seat;
}
