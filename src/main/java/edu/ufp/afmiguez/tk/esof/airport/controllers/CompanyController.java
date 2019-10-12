package edu.ufp.afmiguez.tk.esof.airport.controllers;


import edu.ufp.afmiguez.tk.esof.airport.models.Company;
import edu.ufp.afmiguez.tk.esof.airport.repositories.CompanyRepo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private CompanyRepo companyRepo;

    public CompanyController(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Company>> getAllCompanies(){
        return ResponseEntity.ok(this.companyRepo.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Company> createNewCompany(@RequestBody Company company){
        /*
        TODO some checks are missing
         */
        return ResponseEntity.ok(this.companyRepo.save(company));
    }


}
