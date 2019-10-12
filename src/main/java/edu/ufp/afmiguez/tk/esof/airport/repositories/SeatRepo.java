package edu.ufp.afmiguez.tk.esof.airport.repositories;

import edu.ufp.afmiguez.tk.esof.airport.models.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends CrudRepository<Seat,Long> {
}
