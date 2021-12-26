package com.airlines.service;

import com.airlines.exceptions.AirlineNotFoundException;
import com.airlines.model.Airline;


import java.util.List;

public interface IAirlineService {

    Airline addAirline(Airline airline);
    void updateAirline(Airline airline);
    void deleteAirline(int airlineId);
    Airline getById(int airlineId) throws AirlineNotFoundException;
    List<Airline> getAll();

    List<Airline> getByName(String name) throws AirlineNotFoundException;
    List<Airline> getByCategory(String category) throws AirlineNotFoundException;
    List<Airline> getByNameCategory(String name,String category) throws AirlineNotFoundException;
    List<Airline> getByTourPackage(String name) throws AirlineNotFoundException;
    List<Airline> getByPackagePrice(int price) throws AirlineNotFoundException;
    List<Airline> getBySourceDest(String source,String destination) throws AirlineNotFoundException;
    List<Airline> getByRanking(double ranking) throws AirlineNotFoundException;
    List<Airline> getByOwner(String owner) throws AirlineNotFoundException;
    List<Airline> getByCountry(String country) throws AirlineNotFoundException;
    List<Airline> getByYear(int yearOfOrigin) throws AirlineNotFoundException;
    List<Airline> getByRankingCountry(double ranking,String country) throws AirlineNotFoundException;

}
