package com.airlines.service;

import com.airlines.exceptions.FlightNotFoundException;

import com.airlines.model.Flight;


import java.util.List;

public interface IFlightService {

    Flight addFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(int flightId);

    List<Flight>  getAll();
    Flight getById(int flightId) throws FlightNotFoundException;
    List<Flight> getByName(String name) throws FlightNotFoundException;
    List<Flight> getByNameFacility(String name,String facility) throws FlightNotFoundException;
    List<Flight> getByIdName(int flightId,String name) throws FlightNotFoundException;
    List<Flight> getByFacility(String facility) throws FlightNotFoundException;
    List<Flight> getBySource(String source) throws FlightNotFoundException;
    List<Flight> getByDestination(String destination) throws FlightNotFoundException;
    List<Flight> getBySourceDest(String source,String destination) throws FlightNotFoundException;
    List<Flight> getBySourceFacility(String source,String facility) throws FlightNotFoundException;
    List<Flight> getBySourDesFacility(String source, String destination,String facility) throws FlightNotFoundException;

}
