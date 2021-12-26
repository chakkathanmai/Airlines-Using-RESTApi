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

    /**
     * Adds new airline in the database
     * @param airline is an airline object in the database
     * @return Returns the newly created airline object from the database
     */
    @Override
    public Airline addAirline(Airline airline) {

        return airlineRepository.save(airline);
    }

    /**
     * Updates an airline in the database
     * @param airline airline object with id
     */
    @Override
    public void updateAirline(Airline airline) {

        airlineRepository.save(airline);
    }

    /**
     * Delete a single airline in the database
     * @param airlineId airline id to delete the airline in the database
     */
    @Override
    public void deleteAirline(int airlineId) {

        airlineRepository.deleteById(airlineId);
    }

    /**
     * Finds airline based on airline id provided
     * @param airlineId id of the airline in the database
     * @return Returns an airline found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public Airline getById(int airlineId) throws AirlineNotFoundException {
        return airlineRepository.findById(airlineId).orElseThrow(()->new AirlineNotFoundException("Airline With Id Not Found"));
    }

    /**
     * Returns all the airlines present in the database
     * @return Returns a list of airlines found in the database
     */
    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    /**
     *Finds airlines based on airline name provided
     * @param name name of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByName(String name) throws AirlineNotFoundException {
       List<Airline> airlines =airlineRepository.findByName(name);

       if(airlines.isEmpty()){
           throw new AirlineNotFoundException("InCorrect Airline Name");
       }
        return airlines;
    }

    /**
     * Finds airlines based on airline category provided
     * @param category category of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByCategory(String category) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByCategory(Category.valueOf(category));

        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airline with Category Not Found");
        }

         return airlines;
    }

    /**
     * Finds airlines based on airline name and category provided
     * @param name name of the airline in the database
     * @param category category of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByNameCategory(String name, String category) throws AirlineNotFoundException {
        List<Airline> airlines =airlineRepository.findByNameAndCategory(name, Category.valueOf(category));
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airline with Name and Category Not Found");
        }
        return airlines;
    }

    /**
     * Finds airlines based on airline name and category provided
     * @param name name of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByTourPackage(String name) throws AirlineNotFoundException {
        List<Airline> airlines= airlineRepository.findByPackage(name);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with TourPackage Not Found");
        }
        return airlines;
    }

    /**
     * Finds airlines based on airline package price provided
     * @param price tourPackage price of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByPackagePrice(int price) throws AirlineNotFoundException {
        List<Airline> airlines= airlineRepository.findByPackagePrice(price);

        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given Tour package price not Found");
        }
   return airlines;
    }

    /**
     * Finds airlines based on airline source and destination provided
     * @param source source of the airline in the database
     * @param destination destination of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getBySourceDest(String source, String destination) throws AirlineNotFoundException {
        List<Airline> airlines=  airlineRepository.findBySourceDest(source, destination);

        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with Tour Package given Source and destination not Found");
        }

    return airlines;
    }

    /**
     * Finds airlines based on airline ranking provided
     * @param ranking ranking of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByRanking(double ranking) throws AirlineNotFoundException {

       List<Airline> airlines = airlineRepository.findByRanking(ranking);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given ranking not Found");
        }
        return airlines;
    }

    /**
     * Finds airlines based on owner provided
     * @param owner owner of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByOwner(String owner) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByOwner(owner);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given owner not Found");
        }
        return airlines;
    }

    /**
     * Finds airlines based on country provided
     * @param country country of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByCountry(String country) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByCountry(country);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given country not Found");
        }
        return airlines;
    }

    /**
     * Finds airlines based on year provided
     * @param yearOfOrigin origin year of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByYear(int yearOfOrigin) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByYear(yearOfOrigin);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given year of origin not Found");
        }
        return airlines;
    }

    /**
     * Finds airlines based on ranking and country provided
     * @param ranking ranking of the airline in the database
     * @param country country of the airline in the database
     * @return Returns a list of airlines found in the database
     * @throws AirlineNotFoundException If no airline found in the database
     */
    @Override
    public List<Airline> getByRankingCountry(double ranking, String country) throws AirlineNotFoundException {
        List<Airline> airlines = airlineRepository.findByRankCountry(ranking, country);
        if(airlines.isEmpty()){
            throw new AirlineNotFoundException("Airlines with given ranking and country not Found");
        }
        return airlines;
    }

}
