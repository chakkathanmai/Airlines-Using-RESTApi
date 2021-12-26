package com.airlines.controllers;

import com.airlines.exceptions.FlightNotFoundException;
import com.airlines.model.Airline;
import com.airlines.model.Flight;
import com.airlines.service.IFlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flight-api")
public class FlightController {

    @Autowired
   private IFlightService flightService;
   private Logger logger = LoggerFactory.getLogger(FlightController.class);

    /**
     *
     * @param flight
     * @return
     */
   @PostMapping("/flights")
   public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
       logger.debug("inside Add Flight method");
       HttpHeaders headers= new HttpHeaders();
       headers.add("desc","Adding new Flights");
       Flight flight1 = flightService.addFlight(flight);
       logger.info("Flight added"+flight1);
       return  ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(flight1);
    }

    /**
     *
     * @param flight
     * @return
     */
    @PutMapping("/flights")
    public ResponseEntity<Void> updateFlight(@RequestBody Flight flight){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Updating Flight");
        flightService.updateFlight(flight);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    /**
     *
     * @param flightId
     * @return
     */
    @DeleteMapping("flights/{flightId}")
    public  ResponseEntity<String> deleteFlight(@PathVariable("flightId") int flightId){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Deleting a flight");
        flightService.deleteFlight(flightId);
        return   ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    /**
     *
     * @return
     */
    @GetMapping("/flights")
    public ResponseEntity<List<Airline>>  getAll(){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Getting All Flights");
        headers.add("info","Flight Details");
        List<Flight> flights = flightService.getAll();
        ResponseEntity<List<Airline>> flightResponse= new ResponseEntity(flights,headers,HttpStatus.OK);
        return flightResponse;
    }

    /**
     *
     * @param flightId
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flight/id/{flightId}")
    public ResponseEntity<Flight> getById(@PathVariable("flightId") int flightId) throws FlightNotFoundException{
        logger.debug("inside get Airlines by Id method");
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Getting Flight by Id");
        Flight flight=flightService.getById(flightId);
        logger.info("Get one Flight  "+flight);
        return  ResponseEntity.ok().headers(headers).body(flight);
    }

    /**
     *
     * @param name
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flight/name/{name}")
    public ResponseEntity<List<Flight>> getByName(@PathVariable("name") String name) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flight by name");
       List<Flight> flight =flightService.getByName(name);
        return ResponseEntity.ok().headers(headers).body(flight);
    }

    /**
     *
     * @param name
     * @param facility
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flight/name/{name}/facility/{facility}")
    public ResponseEntity<List<Flight>> getByNameFacility(@PathVariable("name")String name,@PathVariable("facility")String facility) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flight by name and facility");
        List<Flight> flight =flightService.getByNameFacility(name, facility);
        return ResponseEntity.ok().headers(headers).body(flight);
    }

    /**
     *
     * @param flightId
     * @param name
     * @return
     * @throws FlightNotFoundException
     */

    @GetMapping("flights/id/{id}/name/{name}")
    public ResponseEntity<List<Flight>> getByIdAndName(@PathVariable("id") int flightId,@PathVariable("name") String name) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flight by FlightId and name");
        List<Flight> flights =flightService.getByIdName(flightId, name);
        return ResponseEntity.ok().headers(headers).body(flights);
    }

    /**
     *
     * @param facility
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flights/facility/{facility}")
    public ResponseEntity<List<Flight>> getByFacility(@PathVariable("facility") String facility) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flights by Facilities");
        List<Flight> flights =flightService.getByFacility(facility);
        return ResponseEntity.ok().headers(headers).body(flights);
    }

    /**
     *
     * @param source
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flights/source/{source}")
    public ResponseEntity<List<Flight>> getBySource(@PathVariable("source") String source) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flights by Source");
        List<Flight> flights =flightService.getBySource(source);
        return ResponseEntity.ok().headers(headers).body(flights);
    }

    /**
     *
     * @param destination
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flights/destination/{destination}")
    public ResponseEntity<List<Flight>> getByDestination(@PathVariable("destination") String destination) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flights by destination");
        List<Flight> flights =flightService.getByDestination(destination);
        return ResponseEntity.ok().headers(headers).body(flights);
    }

    /**
     *
     * @param source
     * @param destination
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flights/source/{source}/destinations/{destination}")
    public ResponseEntity<List<Flight>> getBySourceDestination(@PathVariable("source") String source,@PathVariable("destination") String destination) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flights by destination");
        List<Flight> flights =flightService.getByDestination(destination);
        return ResponseEntity.ok().headers(headers).body(flights);

    }

    /**
     *
     * @param source
     * @param facility
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flights/source/{source}/facility/{facility}")
    public ResponseEntity<List<Flight>> getBySourceAndFacility(@PathVariable("source") String source,@PathVariable("facility") String facility) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flights by source and facility");
        List<Flight> flights =flightService.getBySourceFacility(source, facility);
        return ResponseEntity.ok().headers(headers).body(flights);
    }

    /**
     *
     * @param source
     * @param destination
     * @param facility
     * @return
     * @throws FlightNotFoundException
     */
    @GetMapping("flights/source/{source}/destination/{destination}/facility/{facility}")
    public ResponseEntity<List<Flight>> getBySourDesFacility(@PathVariable("source") String source,@PathVariable("destination") String destination,@PathVariable("facility") String facility) throws FlightNotFoundException{
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Flights by source destination and facility");
        List<Flight> flights =flightService.getBySourDesFacility(source, destination, facility);
        return ResponseEntity.ok().headers(headers).body(flights);
    }


}
