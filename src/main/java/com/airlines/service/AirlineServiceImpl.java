package com.airlines.service;

import com.airlines.exceptions.AirlineNotFoundException;
import com.airlines.model.Airline;
import com.airlines.model.Category;
import com.airlines.repository.IAirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements IAirlineService{

    @Autowired
    private IAirlineRepository airlineRepository;

    @Override
    public Airline addAirline(Airline airline) {

        return airlineRepository.save(airline);
    }

    @Override
    public void updateAirline(Airline airline) {

        airlineRepository.save(airline);
    }

    @Override
    public void deleteAirline(int airlineId) {

        airlineRepository.deleteById(airlineId);
    }

    @Override
    public Airline getById(int airlineId) throws AirlineNotFoundException {
        return airlineRepository.findById(airlineId).orElseThrow(()->new AirlineNotFoundException("Airline With Id Not Found"));
    }

    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    @Override
    public List<Airline> getByName(String name) throws AirlineNotFoundException {
       List<Airline> airlines =airlineRepository.findByName(name);

       if(airlines.isEmpty()){
           throw new AirlineNotFoundException("InCorrect Airline Name");
       }
        return airlines;
    }

    @Override
    public List<Airline> getByCategory(String category) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByCategory(Category.valueOf(category));

        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airline with Category Not Found");
        }

         return airlines;
    }

    @Override
    public List<Airline> getByNameAndCategory(String name, String category) throws AirlineNotFoundException {
        List<Airline> airlines =airlineRepository.findByNameAndCategory(name, Category.valueOf(category));
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airline with Name and Category Not Found");
        }
        return airlines;
    }

    @Override
    public List<Airline> getByTourPackage(String name) throws AirlineNotFoundException {
        List<Airline> airlines= airlineRepository.findByTourPackage(name);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with TourPackage Not Found");
        }
        return airlines;
    }


    @Override
    public List<Airline> getByTourPackageLesserPrice(int price) throws AirlineNotFoundException {
        List<Airline> airlines= airlineRepository.findByTourPackageLesserPrice(price);

        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given Tour package price not Found");
        }
   return airlines;
    }

    @Override
    public List<Airline> getBySourceAndDestination(String source, String destination) throws AirlineNotFoundException {
        List<Airline> airlines=  airlineRepository.findBySourceAndDestination(source, destination);

        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with Tour Package given Source and destination not Found");
        }

    return airlines;
    }

    @Override
    public List<Airline> getByRanking(double ranking) throws AirlineNotFoundException {

       List<Airline> airlines = airlineRepository.findByRanking(ranking);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given ranking not Found");
        }
        return airlines;
    }

    @Override
    public List<Airline> getByOwner(String owner) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByOwner(owner);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given owner not Found");
        }
        return airlines;
    }

    @Override
    public List<Airline> getByCountry(String country) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByCountry(country);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given country not Found");
        }
        return airlines;
    }

    @Override
    public List<Airline> getByYearOfOrigin(int yearOfOrigin) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByYearOfOrigin(yearOfOrigin);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given year of origin not Found");
        }
        return airlines;
    }

    @Override
    public List<Airline> getByRankingAndCountry(double ranking, String country) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByRankingAndCountry(ranking, country);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given ranking and country not Found");
        }
        return airlines;
    }

}
