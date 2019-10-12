package edu.ufp.afmiguez.tk.esof.airport.repositories;

import edu.ufp.afmiguez.tk.esof.airport.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends CrudRepository<Company,Long> {
    Optional<Company> findByName(String name);
}
