package edu.ufp.afmiguez.tk.esof.airport.repositories;

import edu.ufp.afmiguez.tk.esof.airport.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepo extends CrudRepository<Flight,Long> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    Iterable<Flight> findAllByCompany_Name(String name);
    Iterable<Flight> findAllByArrival_Name(String arrivalName);
    Iterable<Flight> findAllByArrival_City_Name(String arrivalCity);

    Iterable<Flight> findAllByDeparture_Name(String departureName);
    Iterable<Flight> findAllByDeparture_City_Name(String departureCity);
}
