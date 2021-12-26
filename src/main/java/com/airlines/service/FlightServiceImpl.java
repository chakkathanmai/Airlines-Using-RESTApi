package com.airlines.service;

import com.airlines.exceptions.FlightNotFoundException;
import com.airlines.model.Flight;
import com.airlines.model.FlightFacility;
import com.airlines.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {
    private IFlightRepository flightRepository;

    @Autowired
    public void setFlightRepository(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    /**
     * Adds new flight in the database
     *
     * @param flight is a flight object in the database
     * @return returns the newly created flight object from the database
     */
    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    /**
     * Updates a fight in the database
     *
     * @param flight is a flight object in the database
     */
    @Override
    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    /**
     * Delete a single flight id in the database
     *
     * @param flightId flight id to delete the flight in the database
     */
    @Override
    public void deleteFlight(int flightId) {
        flightRepository.deleteById(flightId);
    }

    /**
     * Get all flights in the database
     *
     * @return Returns a list of flights in the database
     */
    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    /**
     * Finds flight based on the flight id provided
     *
     * @param flightId id of the flight in the database
     * @return Returns a Flight in the database
     * @throws FlightNotFoundException
     */
    @Override
    public Flight getById(int flightId) throws FlightNotFoundException {
        return flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException("Flight with id Not Found"));
    }

    /**
     * Finds flights based on the flight name provided
     *
     * @param name name of the flight in the database
     * @return Returns a list of flights in the database
     * @throws FlightNotFoundException If no flight found in the database
     */
    @Override
    public List<Flight> getByName(String name) throws FlightNotFoundException {

        List<Flight> flights = flightRepository.findByName(name);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with name not found");
        }
        return flights;
    }

    /**
     * Finds flights based on flight name and facility provided
     *
     * @param name     name of the flight in the database
     * @param facility facility of the flight in the database
     * @return Returns a list of flights in the database
     * @throws FlightNotFoundException If no flight found in the database
     */
    @Override
    public List<Flight> getByNameFacility(String name, String facility) throws FlightNotFoundException {

        List<Flight> flights = flightRepository.findByNameFacility(name, facility);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with name and facility not found");
        }
        return flights;
    }

    /**
     * Finds flights based on the flight id and name provided
     *
     * @param flightId flightId of the flight in the database
     * @param name     name of the flight in the database
     * @return Returns a list of flights found in the database
     * @throws FlightNotFoundException If no flight found in the database
     */
    @Override
    public List<Flight> getByIdName(int flightId, String name) throws FlightNotFoundException {

        List<Flight> flights = flightRepository.findByIdAndName(flightId, name);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with name and Id not found");
        }
        return flights;
    }

    /**
     * Finds flights based on the facility provided
     *
     * @param facility facility of the flight in the database
     * @return Returns a list of flights found in the database
     * @throws FlightNotFoundException If no flights found in the database
     */
    @Override
    public List<Flight> getByFacility(String facility) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByFacility(FlightFacility.valueOf(facility));
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with facility not found");
        }
        return flights;
    }

    /**
     * Finds flights based on source provided
     *
     * @param source source of the flight in the database
     * @return Returns a list of flights found in the database
     * @throws FlightNotFoundException If no flights found in the database
     */
    @Override
    public List<Flight> getBySource(String source) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySource(source);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with given source not found");
        }
        return flights;
    }

    /**
     * Finds flights based on the destination provided
     *
     * @param destination destination of the flights in the database
     * @return Returns a list of flights found in the database
     * @throws FlightNotFoundException If no flights found in the database
     */
    @Override
    public List<Flight> getByDestination(String destination) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByDestination(destination);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with given destination not found");
        }
        return flights;
    }

    /**
     * Finds flights based on the source and destination provided
     *
     * @param source      source of the flights in the database
     * @param destination destination of the flights in the database
     * @return Returns a list of flights found in the database
     * @throws FlightNotFoundException If no flights found in the database
     */
    @Override
    public List<Flight> getBySourceDest(String source, String destination) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySourceDest(source, destination);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with given source and destination not found");
        }
        return flights;
    }

    /**
     * Finds flights based on the source and facility provided
     *
     * @param source   source of the flights in the database
     * @param facility facility of the flights in the database
     * @return Returns a list of flights found in the database
     * @throws FlightNotFoundException If no flights found in the database
     */
    @Override
    public List<Flight> getBySourceFacility(String source, String facility) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySourceAndFacility(source, FlightFacility.valueOf(facility));
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with given source and facility not found");
        }
        return flights;
    }

    /**
     * Finds flights based on the source destination and facility provided
     *
     * @param source      source of the flights in the database
     * @param destination destination of the flights in the database
     * @param facility    facility of the flights in the database
     * @return Returns a list of flights found in the database
     * @throws FlightNotFoundException If no flights found in the database
     */
    @Override
    public List<Flight> getBySourDesFacility(String source, String destination, String facility) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findBySourDesFacility(source, destination, FlightFacility.valueOf(facility));
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("Flight with given source destination and facility not found");
        }
        return flights;
    }


}
