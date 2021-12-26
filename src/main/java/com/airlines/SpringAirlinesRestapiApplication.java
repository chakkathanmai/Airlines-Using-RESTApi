package com.airlines;

import com.airlines.model.*;
import com.airlines.service.IAirlineService;
import com.airlines.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class SpringAirlinesRestapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringAirlinesRestapiApplication.class, args);
    }

    private IFlightService flightService;

    @Autowired
    public void setFlightService(IFlightService flightService) {
        this.flightService = flightService;
    }

    private IAirlineService airlineService;

    @Autowired
    public void setAirlineService(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @Override
    public void run(String... args) throws Exception {

//
//        Facilities facilities1 = new Facilities(FlightFacility.MEALS, "Non Veg and Veg meals provided");
//        Facilities facilities2 = new Facilities(FlightFacility.DRINKS, "provided");
//        Facilities facilities3 = new Facilities(FlightFacility.AMENITIESKIT, "provided");
//        List<Facilities> facilities = Arrays.asList(facilities1, facilities2);
//
//        Facilities facilities4 = new Facilities(FlightFacility.MEALS, "Non Veg and Veg meals provided");
//        Facilities facilities5 = new Facilities(FlightFacility.PERSONALTV, "Available with all OTT movies");
//        Facilities facilities6 = new Facilities(FlightFacility.CONVERTABlESEATS, "provided");
//        List<Facilities> facilities7 = (Arrays.asList(facilities4, facilities5));
//
//        Flight flight1 = new Flight("MH303", "Mumbai", "Hyderabad", facilities7);
//        Flight flight2 = new Flight("HC333", "Hyderabad", "Chennai", facilities);
//        Set<Flight> flights = new HashSet<>(Arrays.asList(flight1, flight2));
//
//        Details details = new Details(4.5, "TATA", 1948, "India");
//
//        TourPackages packages1 = new TourPackages("MaldivesTrip", 100000, "Chennai", "Maldives");
//        TourPackages packages2 = new TourPackages("FranceTrip", 700000, "Bangalore", "France");
//        Set<TourPackages> tourPackages = new HashSet<>(Arrays.asList(packages1, packages2));
//
//        Airline airline = new Airline("AirIndia", Category.INTERNATIONAL, details, flights, tourPackages);
//
//        //System.out.println("Airlines"+airlineService.addAirline(airline));
//        List<Flight> flight = flightService.getByFacility("DRINKS");
//        System.out.println(flight);
//
//        Airline airline1 = airlineService.getById(1);
//        //System.out.println(airline1);
//
//        //List<Airline> airline2 = airlineService.getByTourPackage("FranceTrip");
//        //System.out.println(airline2);
//
//        List<Flight> flights1 = flightService.getAll();
//        //System.out.println(flights1);


    }
}
