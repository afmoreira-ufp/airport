package edu.ufp.afmiguez.tk.esof.airport.controllers;

import edu.ufp.afmiguez.tk.esof.airport.models.Airport;
import edu.ufp.afmiguez.tk.esof.airport.repositories.AirportRepo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/airport")
public class AirportController {
    private AirportRepo airportRepo;

    public AirportController(AirportRepo airportRepo) {
        this.airportRepo = airportRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Airport>> getAllAirports(){
        return ResponseEntity.ok(this.airportRepo.findAll());
    }


}
