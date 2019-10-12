package edu.ufp.afmiguez.tk.esof.airport.repositories;

import edu.ufp.afmiguez.tk.esof.airport.models.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepo extends CrudRepository<Airport,Long> {
    Optional<Airport> findByName(String name);
    Optional<Airport> findByCity_Name(String cityName);
}
