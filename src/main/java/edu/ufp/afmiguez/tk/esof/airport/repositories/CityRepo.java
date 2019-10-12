package edu.ufp.afmiguez.tk.esof.airport.repositories;

import edu.ufp.afmiguez.tk.esof.airport.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepo extends CrudRepository<City,Long> {
    Optional<City> findByName(String name);
}
