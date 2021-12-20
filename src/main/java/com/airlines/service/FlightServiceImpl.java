package com.airlines.service;

import com.airlines.exceptions.AirlineNotFoundException;
import com.airlines.exceptions.FlightNotFoundException;
import com.airlines.model.Airline;
import com.airlines.model.Facilities;
import com.airlines.model.Flight;
import com.airlines.model.FlightFacility;
import com.airlines.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService{
    private IFlightRepository flightRepository;

    @Autowired
    public void setFlightRepository(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void updateFlight(Flight flight) {
       flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(int flightId) {
       flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getById(int flightId) throws FlightNotFoundException {
        return flightRepository.findById(flightId).orElseThrow(()->new FlightNotFoundException("Flight with id Not Found"));
    }

    @Override
    public Flight getByName(String name) throws FlightNotFoundException {

        Flight flight =null;
        flight= flightRepository.findByName(name);
        if(flight==null){
            throw new FlightNotFoundException("Flight with ");
        }
        return flight;
    }

    @Override
    public Flight getByNameAndFacilities(String name, String facility) throws FlightNotFoundException {

       Flight flight =null;
       flight= flightRepository.findByNameAndFacilities(name, facility);
       if(flight==null){
           throw new FlightNotFoundException("Flight with ");
       }
        return flight;
    }

    @Override
    public List<Flight> getByIdAndName(int flightId, String name) throws FlightNotFoundException {

        List<Flight> flights = flightRepository.findByIdAndName(flightId, name);
        if (flights.isEmpty()){
            throw  new FlightNotFoundException("Flight with name and Id not found");
        }
        return flights;
    }

    @Override
    public List<Flight> getByFacility(String facility) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByFacility(FlightFacility.valueOf(facility));
        if (flights.isEmpty()){
            throw  new FlightNotFoundException("Flight with facility not found");
        }
        return flights;
    }

    @Override
    public List<Flight> getBySource(String source) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySource(source);
        if (flights.isEmpty()){
            throw  new FlightNotFoundException("Flight with given source not found");
        }
        return flights;
    }

    @Override
    public List<Flight> getByDestination(String destination) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByDestination(destination);
        if (flights.isEmpty()){
            throw  new FlightNotFoundException("Flight with given destination not found");
        }
        return flights;
    }

    @Override
    public List<Flight> getBySourceAndDestination(String source, String destination) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySourceAndDestination(source, destination);
        if (flights.isEmpty()){
            throw  new FlightNotFoundException("Flight with given source and destination not found");
        }
        return flights;
    }

    @Override
    public List<Flight> getBySourceAndFacility(String source, String facility) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySourceAndFacility(source,FlightFacility.valueOf(facility));
        if (flights.isEmpty()){
            throw  new FlightNotFoundException("Flight with given source and facility not found");
        }
        return flights;
    }

    @Override
    public List<Flight> getBySourDesFacility(String source, String destination,String facility) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySourDesFacility(source,destination,FlightFacility.valueOf(facility));
        if (flights.isEmpty()){
            throw  new FlightNotFoundException("Flight with given source destination and facility not found");
        }
        return flights;
    }


}
