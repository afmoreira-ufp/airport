package edu.ufp.afmiguez.tk.esof.airport;

import edu.ufp.afmiguez.tk.esof.airport.models.*;
import edu.ufp.afmiguez.tk.esof.airport.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CityRepo cityRepo;

    private AirportRepo airportRepo;

    private FlightRepo flightRepo;

    private PlaneRepo planeRepo;

    private CompanyRepo companyRepo;


    public Bootstrap(CityRepo cityRepo, AirportRepo airportRepo, FlightRepo flightRepo, PlaneRepo planeRepo,CompanyRepo companyRepo) {
        this.cityRepo = cityRepo;
        this.airportRepo = airportRepo;
        this.flightRepo = flightRepo;
        this.planeRepo = planeRepo;
        this.companyRepo=companyRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        City oporto=new City("Oporto");
        oporto.setAirport(new Airport("Francisco Sá Carneiro"));

        City lisbon=new City("Lisbon");
        lisbon.setAirport(new Airport("Humberto Delgado"));

        this.cityRepo.save(oporto);
        this.cityRepo.save(lisbon);

        Company tap=new Company("TAP");

        Pilot zeDasCouves=new Pilot("Zé das Couves");
        tap.addPilot(zeDasCouves);

        Pilot mariaSerafina=new Pilot("Maria Serafina");
        tap.addPilot(mariaSerafina);


        Plane airbus340=new Plane("Airbus A340","XHR02");

        Flight oportoLisbonFlight=new Flight(LocalDate.of(2019,9,1),"VR6402");
        oportoLisbonFlight.setDeparture(this.airportRepo.findByCity_Name("Oporto").get());
        oportoLisbonFlight.setArrival(this.airportRepo.findByCity_Name("Lisbon").get());

        zeDasCouves.addFlight(oportoLisbonFlight);


        airbus340.addFlight(oportoLisbonFlight);

        Plane boeing737=new Plane("Boeing 737","CTN10");

        Flight lisbonOportoFlight=new Flight(LocalDate.of(2019,9,2),"VR6513");
        lisbonOportoFlight.setDeparture(this.airportRepo.findByCity_Name("Lisbon").get());
        lisbonOportoFlight.setArrival(this.airportRepo.findByCity_Name("Oporto").get());

        mariaSerafina.addFlight(lisbonOportoFlight);

        boeing737.addFlight(lisbonOportoFlight);

        tap.addFlight(oportoLisbonFlight);
        tap.addFlight(lisbonOportoFlight);

        this.companyRepo.save(tap);

        System.out.println(this.airportRepo.findAll());
        System.out.println(this.cityRepo.findAll());

        System.out.println(this.companyRepo.findAll());

        System.out.println(this.flightRepo.findAll());

        System.out.println(this.planeRepo.findAll());

        System.out.println();
        System.out.println(this.flightRepo.findAllByArrival_City_Name("Oporto"));
        System.out.println();
        System.out.println(this.flightRepo.findAllByCompany_Name("TAP"));

    }
}
