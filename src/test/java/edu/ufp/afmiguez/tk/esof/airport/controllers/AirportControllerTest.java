package edu.ufp.afmiguez.tk.esof.airport.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.afmiguez.tk.esof.airport.models.Airport;
import edu.ufp.afmiguez.tk.esof.airport.repositories.AirportRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AirportController.class)
public class AirportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportRepo airportRepo;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllAirports() throws Exception {

        Set<Airport> airports=new HashSet<>();

        airports.add(new Airport("airport1"));
        airports.add(new Airport("airport2"));
        airports.add(new Airport("airport3"));

        when(this.airportRepo.findAll()).thenReturn(airports);


        String responseGetAllAirport=this.mockMvc.perform(get("/airport")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();


        Set<Airport> results=this.objectMapper.readValue(responseGetAllAirport,new TypeReference<Set<Airport>>(){});

        assertTrue(results.containsAll(airports));

    }
}