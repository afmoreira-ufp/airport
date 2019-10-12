package edu.ufp.afmiguez.tk.esof.airport.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Airport extends BaseModel{
    private String name;

    @OneToOne
    private City city;

    public Airport(String name) {
        this.setName(name);
    }
}
