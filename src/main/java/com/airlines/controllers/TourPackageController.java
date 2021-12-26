package com.airlines.controllers;

import com.airlines.exceptions.PackageNotFoundException;
import com.airlines.model.TourPackages;
import com.airlines.service.IPackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("package-api")
public class TourPackageController {
    @Autowired
    private IPackageService packageService;


    private Logger logger = LoggerFactory.getLogger(TourPackageController.class);


    /**
     *
     * @param tourPackages
     * @return
     */
    @PostMapping("/packages")
    public ResponseEntity<TourPackages> addPackage(@RequestBody TourPackages tourPackages){
        logger.debug("inside Add tour packages method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Adding new package");
        TourPackages packages = packageService.addPackage(tourPackages);
        logger.info("Package added"+packages);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(packages);
    }

    @PutMapping("/packages")
    public  ResponseEntity<Void> updatePackage(@RequestBody TourPackages tourPackages){
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Updating TourPackages");
        packageService.updatePackage(tourPackages);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }
    @DeleteMapping("packages/{packageId}")
    public ResponseEntity<String> delete(@PathVariable("packageId") int packageId){
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Deleting a TourPackage");
        packageService.deletePackage(packageId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }
    @GetMapping("/packages")
    public  ResponseEntity<List<TourPackages>> getAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages> tourPackages = packageService.getAll();
        return  ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("/packages/name/{name}")
    public  ResponseEntity<List<TourPackages>> getByName(@PathVariable("name") String name) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages By Name");
        List<TourPackages> tourPackages = packageService.getByName(name);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("/packages/id/{packageId}")
    public ResponseEntity<TourPackages> getById(@PathVariable("packageId") int packageId) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages By TourPackages Id");
        TourPackages tourPackages = packageService.getById(packageId);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("/packages/cost/{cost}")
    public  ResponseEntity<List<TourPackages>> getByCost(@PathVariable("cost") double cost) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages>  tourPackages = packageService.getByCost(cost);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("/packages/source/{source}")
    public  ResponseEntity<List<TourPackages>> getBySource(@PathVariable("source") String source) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages>  tourPackages = packageService.getBySource(source);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("/packages/source/{source}/cost/{cost}")
    public  ResponseEntity<List<TourPackages>> getBySourceCost(@PathVariable("source") String source,@PathVariable("cost") double cost) throws  PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages>  tourPackages = packageService.getBySourceCost(source, cost);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("packages/destination/{destination}")
    public  ResponseEntity<List<TourPackages>> getByDestination(@PathVariable("destination") String destination) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages>  tourPackages = packageService.getByDestination(destination);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("packages/source/{source}/destination/{destination}")
    public  ResponseEntity<List<TourPackages>> getBySourceDest(@PathVariable("source") String source,@PathVariable("destination") String destination) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages>  tourPackages = packageService.getBySourceDest(source, destination);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("packages/airlines/{name}")
    public  ResponseEntity<List<TourPackages>> getByAirline(@PathVariable("name") String name) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages>  tourPackages = packageService.getByAirline(name);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }
    @GetMapping("packages/source/{source}/airlines/{name}")
    public  ResponseEntity<List<TourPackages>> getBySourceAirline(@PathVariable("source") String source,@PathVariable("name") String name) throws PackageNotFoundException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Getting All TourPackages");
        List<TourPackages>  tourPackages = packageService.getBySourceAirline(source, name);
        return ResponseEntity.ok().headers(headers).body(tourPackages);
    }

}
