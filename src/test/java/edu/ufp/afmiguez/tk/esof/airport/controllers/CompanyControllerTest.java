package edu.ufp.afmiguez.tk.esof.airport.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.afmiguez.tk.esof.airport.models.Airport;
import edu.ufp.afmiguez.tk.esof.airport.models.Company;
import edu.ufp.afmiguez.tk.esof.airport.repositories.CompanyRepo;
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
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyRepo companyRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllCompanies() throws Exception {

        Set<Company> companies=new HashSet<>();

        companies.add(new Company("company1"));
        companies.add(new Company("company2"));
        companies.add(new Company("company3"));

        when(this.companyRepo.findAll()).thenReturn(companies);


        String responseGetAllAirport=this.mockMvc.perform(get("/company")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();


        Set<Company> results=this.objectMapper.readValue(responseGetAllAirport,new TypeReference<Set<Company>>(){});

        assertTrue(results.containsAll(companies));


    }

    @Test
    public void createNewCompany() throws Exception {
        Company company= new Company("company1");

        Company result=new Company("company1");
        result.setId(1L);

        when(this.companyRepo.save(company)).thenReturn(result);

        String response=this.mockMvc.perform(
                post("/company")
                .content(this.objectMapper.writeValueAsString(company))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Company responseCompany=this.objectMapper.readValue(response,Company.class);

        assertEquals(responseCompany, result);


    }
}