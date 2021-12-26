package com.airlines.service;


import com.airlines.exceptions.PackageNotFoundException;
import com.airlines.model.TourPackages;
import java.util.List;

public interface IPackageService {


    TourPackages addPackage(TourPackages tourPackages);
    void updatePackage(TourPackages tourPackages);
    void deletePackage(int packageId);
    List<TourPackages> getAll();
    List<TourPackages> getByName(String name) throws PackageNotFoundException;
    TourPackages getById(int packageId) throws PackageNotFoundException;
    List<TourPackages> getByCost(double cost) throws PackageNotFoundException;
    List<TourPackages> getBySource(String source) throws PackageNotFoundException;
    List<TourPackages> getBySourceCost(String source,double cost) throws  PackageNotFoundException;
    List<TourPackages> getByDestination(String destination) throws PackageNotFoundException;
    List<TourPackages> getBySourceDest(String source,String destination) throws PackageNotFoundException;
    List<TourPackages> getByAirline(String name) throws PackageNotFoundException;
    List<TourPackages> getBySourceAirline(String source,String name) throws PackageNotFoundException;
}
