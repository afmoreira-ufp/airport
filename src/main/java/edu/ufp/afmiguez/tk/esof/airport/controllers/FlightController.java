package edu.ufp.afmiguez.tk.esof.airport.controllers;


import edu.ufp.afmiguez.tk.esof.airport.models.Flight;
import edu.ufp.afmiguez.tk.esof.airport.repositories.FlightRepo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flight")
public class FlightController {

    private FlightRepo flightRepo;

    public FlightController(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Flight>> getAllFlights(){
        return ResponseEntity.ok(this.flightRepo.findAll());
    }

    @GetMapping(value = "/company/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Flight>> getAllFlightsByCompanyName(@PathVariable("name")String companyName){
        return ResponseEntity.ok(this.flightRepo.findAllByCompany_Name(companyName));
    }

    @GetMapping(value = "/airport/arrival/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Flight>> getAllFlightsByAirportArrivalName(@PathVariable("name") String cityName){
        return ResponseEntity.ok(this.flightRepo.findAllByArrival_City_Name(cityName));
    }

    @GetMapping(value = "/airport/departure/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Flight>> getAllFlightsByAirportDepartureName(@PathVariable("name") String cityName){
        return ResponseEntity.ok(this.flightRepo.findAllByDeparture_City_Name(cityName));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Flight> createNewFlight(@RequestBody Flight flight){
        /*
        TODO some checks are missing
         */
        return ResponseEntity.ok(this.flightRepo.save(flight));
    }

}
