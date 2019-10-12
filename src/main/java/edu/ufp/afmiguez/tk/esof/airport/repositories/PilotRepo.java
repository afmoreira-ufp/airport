package edu.ufp.afmiguez.tk.esof.airport.repositories;

import edu.ufp.afmiguez.tk.esof.airport.models.Pilot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PilotRepo extends CrudRepository<Pilot,Long> {
    Optional<Pilot> findByName(String name);
}
