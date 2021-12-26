package com.airlines.repository;

import com.airlines.exceptions.PackageNotFoundException;
import com.airlines.model.TourPackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPackageRepository extends JpaRepository<TourPackages,Integer> {

    @Query("from TourPackages")
    List<TourPackages> findAll();
    @Query("from TourPackages where packageName LIKE %?1%")
    List<TourPackages> findByName(String name) throws PackageNotFoundException;
    @Query("from TourPackages where packageId=?1")
    TourPackages findById(int packageId) throws PackageNotFoundException;
    @Query("from TourPackages where cost=?1")
    List<TourPackages> findByCost(double cost) throws PackageNotFoundException;
    @Query("from TourPackages where source=?1")
    List<TourPackages> findBySource(String source) throws PackageNotFoundException;
    @Query("from TourPackages where source=?1 and cost=?2")
    List<TourPackages> findBySourceCost(String source,double cost) throws  PackageNotFoundException;
    @Query("from TourPackages where destination=?2")
    List<TourPackages> findByDestination(String destination) throws PackageNotFoundException;
    @Query("from TourPackages t where t.source=?1 and t.destination=?2")
    List<TourPackages> findBySourceDest(String source,String destination) throws PackageNotFoundException;
    @Query("from TourPackages t inner join t.airlines a where a.name LIKE %?1%")
    List<TourPackages> findByAirline(String name) throws PackageNotFoundException;
    @Query("from TourPackages t inner join t.airlines a where t.source=?1 and a.name LIKE %?2%")
    List<TourPackages> findBySourceAirline(String source,String name) throws PackageNotFoundException;
}
