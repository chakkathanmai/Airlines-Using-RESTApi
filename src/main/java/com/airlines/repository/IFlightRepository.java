package com.airlines.repository;

import com.airlines.exceptions.AirlineNotFoundException;
import com.airlines.exceptions.FlightNotFoundException;
import com.airlines.model.Airline;
import com.airlines.model.Flight;
import com.airlines.model.FlightFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Integer> {

   
    Flight findByName(String name) throws FlightNotFoundException;
    List<Flight> findBySource(String source) throws FlightNotFoundException;
    List<Flight> findByDestination(String destination) throws FlightNotFoundException;

    @Query("from Flight f inner join f.facilities fs where f.name=?1 and fs.facilityName=?2")
    Flight findByNameAndFacilities(String name,String facility) throws FlightNotFoundException;
    @Query("from Flight where source=?1 and destination=?2")
    List<Flight> findBySourceAndDestination(String source,String destination) throws FlightNotFoundException;
    @Query("from Flight where flightId=?1 and name=?2")
    List<Flight> findByIdAndName(int flightId,String name) throws FlightNotFoundException;
    @Query("from Flight f inner join f.facilities fs where fs.facilityName=?1")
    List<Flight> findByFacility(FlightFacility facility) throws FlightNotFoundException;
    @Query("from Flight f inner join f.facilities fs where f.source=?1 and fs.facilityName=?2")
    List<Flight> findBySourceAndFacility(String source,FlightFacility facility) throws FlightNotFoundException;
    @Query("from Flight f inner join f.facilities fs where f.source=?1 and f.destination=?2 and fs.facilityName=?3")
    List<Flight> findBySourDesFacility(String source,String destination,FlightFacility facility) throws FlightNotFoundException;
}
