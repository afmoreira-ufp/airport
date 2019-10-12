package edu.ufp.afmiguez.tk.esof.airport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class City extends BaseModel{
    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Airport airport;

    public City(String name) {
        this.setName(name);
    }

    public void setAirport(Airport airport){
        this.airport=airport;
        airport.setCity(this);
    }

    @ToString.Include
    @JsonInclude
    public String airport(){
        return this.airport.getName();
    }
}
