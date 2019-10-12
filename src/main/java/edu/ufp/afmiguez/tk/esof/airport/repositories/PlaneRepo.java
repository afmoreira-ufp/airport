package edu.ufp.afmiguez.tk.esof.airport.repositories;

import edu.ufp.afmiguez.tk.esof.airport.models.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaneRepo extends CrudRepository<Plane,Long> {
    Optional<Plane> findBySerialNumber(String serialNumber);
}
