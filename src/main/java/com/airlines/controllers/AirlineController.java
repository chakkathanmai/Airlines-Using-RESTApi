package com.airlines.controllers;

import com.airlines.model.Airline;
import com.airlines.service.IAirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airlines-api")
public class AirlineController {

    private IAirlineService airlineService;
    private Logger logger = LoggerFactory.getLogger(AirlineController.class);

    @Autowired
    public void setAirlineService(IAirlineService airlineService) {
        this.airlineService = airlineService;
    }

    /**
     *
     * @param airline
     * @return
     */
   @PostMapping("/airlines")
   public ResponseEntity<Airline> addAirline(@RequestBody Airline airline){
       logger.debug("inside Add Airline method");
       HttpHeaders headers= new HttpHeaders();
       headers.add("desc","Adding new Airline");
       Airline aairline =airlineService.addAirline(airline);
       logger.info("Airline added  "+aairline);
       return  ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(aairline);
    }

    /**
     *
     * @param airline
     * @return
     */
    @PutMapping("/airlines")
    public ResponseEntity<Void> updateAirline(@RequestBody Airline airline){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Updating  Airline");
        airlineService.updateAirline(airline);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    /**
     *
     * @param airlineId
     * @return
     */
    @DeleteMapping("/airlines/{airlineId}")
    ResponseEntity<String> deleteAirline(@PathVariable("airlineId") int airlineId){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Deleting a Airline");
        airlineService.deleteAirline(airlineId);
       return   ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    /**
     *
     * @param airlineId
     * @return
     */
    @GetMapping("/airlines/id/{airlinesId}")
    public ResponseEntity<Airline> getById(@PathVariable("airlinesId") int airlineId){
        logger.debug("inside get Airlines by Id method");
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Getting Airline by Id");
        Airline airline =airlineService.getById(airlineId);
        logger.info("Get one Airline  "+airline);
        return  ResponseEntity.ok().headers(headers).body(airline);
    }

    /**
     *
     * @return
     */
    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAll(){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","Getting All Airline");
        headers.add("info","Airline Details");
        List<Airline> airline =airlineService.getAll();
        ResponseEntity<List<Airline>> airlineResponse= new ResponseEntity(airline,headers,HttpStatus.OK);
        return airlineResponse;
    }

    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/airlines/names/{name}")
   public ResponseEntity<List<Airline>> getByName(@PathVariable("name") String name){
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Getting Airlines by name");
        List<Airline> airlines = airlineService.getByName(name);
        return ResponseEntity.ok().headers(headers).body(airlines);

    }

    /**
     *
     * @param category
     * @return
     */
    @GetMapping("/airlines/category/{category}")
    public ResponseEntity<List<Airline>> getByCategory(@PathVariable("category") String category){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by category");
        List<Airline> airlines = airlineService.getByCategory(category);
        return ResponseEntity.ok().headers(headers).body(airlines);

    }

    /**
     *
     * @param name
     * @param category
     * @return
     */
    @GetMapping("/airlines/name/{name}/category/{category}")
    public ResponseEntity<List<Airline>> getByNameCategory(@PathVariable("name") String name,@PathVariable("category") String category){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by name and category");
        List<Airline> airlines = airlineService.getByNameCategory(name, category);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/airlines/package/name/{name}")
    public ResponseEntity<List<Airline>> getByPackage(@PathVariable("name") String name){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by Tour Package");
        List<Airline> airlines = airlineService.getByTourPackage(name);
        return ResponseEntity.ok().headers(headers).body(airlines);

    }

    /**
     *
     * @param price
     * @return
     */
    @GetMapping("/airlines/packages/priceLesserThanAndEqual/{price}")
    public ResponseEntity<List<Airline>> getByPackagePrice(@PathVariable("price") int price){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by Lesser Tour package price");
        List<Airline> airlines = airlineService.getByPackagePrice(price);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    /**
     *
     * @param source
     * @param destination
     * @return
     */
    @GetMapping("/airlines/packages/source/{source}/packages/destination/{destination}")
    public ResponseEntity<List<Airline>> getBySourceDest(@PathVariable("source") String source,@PathVariable("destination") String destination){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by tour package source and destination");
        List<Airline> airlines = airlineService.getBySourceDest(source, destination);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    /**
     *
     * @param ranking
     * @return
     */
    @GetMapping("/airlines/ranking/{ranking}")
    public ResponseEntity<List<Airline>> getByRanking(@PathVariable("ranking") double ranking){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by ranking");
        List<Airline> airlines = airlineService.getByRanking(ranking);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    /**
     *
     * @param owner
     * @return
     */
    @GetMapping("/airlines/owner/{owner}")
    public ResponseEntity<List<Airline>> getByOwner(@PathVariable("owner") String owner) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Airlines by owner");
        List<Airline> airlines = airlineService.getByOwner(owner);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    /**
     *
     * @param country
     * @return
     */
    @GetMapping("/airlines/country/{country}")
    public ResponseEntity<List<Airline>> getByCountry(@PathVariable("country") String country){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by country");
        List<Airline> airlines = airlineService.getByCountry(country);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    /**
     *
     * @param yearOfOrigin
     * @return
     */
    @GetMapping("/airlines/yearOfOrigin/{year}")
    public ResponseEntity<List<Airline>> getByYear(@PathVariable("year") int yearOfOrigin){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by year of origin");
        List<Airline> airlines = airlineService.getByYear(yearOfOrigin);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    /**
     *
     * @param ranking
     * @param country
     * @return
     */
    @GetMapping("/airlines/ranking/{ranking}/country/{country}")
    public ResponseEntity<List<Airline>> getByRankingCountry(@PathVariable("ranking") double ranking,@PathVariable("country") String country){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting Airlines by ranking and category");
        List<Airline> airlines = airlineService.getByRankingCountry(ranking, country);
        return ResponseEntity.ok().headers(headers).body(airlines);
    }

    
}
