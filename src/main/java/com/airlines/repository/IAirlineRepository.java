package com.airlines.repository;

import com.airlines.exceptions.AirlineNotFoundException;
import com.airlines.model.Airline;
import com.airlines.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAirlineRepository extends JpaRepository<Airline,Integer> {


    List<Airline> findByName(String name) throws AirlineNotFoundException;
    List<Airline> findByCategory(Category category) throws AirlineNotFoundException;
    List<Airline> findByNameAndCategory(String name, Category category) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.packages t where t.packageName=?1")
    List<Airline> findByPackage(String name) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.packages t where t.cost<=?1")
    List<Airline> findByPackagePrice(int price) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.packages t where t.source=?1 and t.destination=?2")
    List<Airline> findBySourceDest(String source,String destination) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.details d where d.ranking=?1")
    List<Airline> findByRanking(double ranking) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.details d where d.owner=?1")
    List<Airline> findByOwner(String owner) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.details d where d.country=?1")
    List<Airline> findByCountry(String country) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.details d where d.yearOfOrigin=?1")
    List<Airline> findByYear(int yearOfOrigin) throws AirlineNotFoundException;

    @Query("from Airline a inner join a.details d where d.ranking=?1 and d.country=?2")
    List<Airline> findByRankCountry(double ranking,String country) throws AirlineNotFoundException;


}
