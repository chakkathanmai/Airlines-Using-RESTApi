package com.airlines.service;

import com.airlines.exceptions.PackageNotFoundException;
import com.airlines.model.TourPackages;
import com.airlines.repository.IPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IPackageServiceImpl implements IPackageService {

    IPackageRepository packageRepository;

    @Autowired
    public void setPackageRepository(IPackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    /**
     * Adds new tourPackages in the database
     *
     * @param tourPackages is a tourPackage object in the database
     * @return Returns the newly created tourPackage  object from the database
     */
    @Override
    public TourPackages addPackage(TourPackages tourPackages) {
        return packageRepository.save(tourPackages);
    }

    /**
     * Updates a tourPackages in the database
     *
     * @param tourPackages tourPackage object with id
     */
    @Override
    public void updatePackage(TourPackages tourPackages) {
        packageRepository.save(tourPackages);
    }

    /**
     * Delete a single tourPackage in the database based on the package id provided
     *
     * @param packageId packages id to find the packages in the database
     */
    @Override
    public void deletePackage(int packageId) {
        packageRepository.deleteById(packageId);
    }

    /**
     * Returns all tourPackages in the database
     *
     * @return Returns a list of tourPackages found in the database
     */
    @Override
    public List<TourPackages> getAll() {
        return packageRepository.findAll();
    }

    /**
     * Finds tourPackage based on package id provided
     *
     * @param name name of the tourPackage in the database
     * @return Returns a list of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getByName(String name) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findByName(name);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("Packages with given name Not Found");
        }
        return packages;
    }

    /**
     * Finds tourPackage based on package id provided
     *
     * @param packageId package id of the tourPackage in the database
     * @return Returns a tourPackage found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public TourPackages getById(int packageId) throws PackageNotFoundException {
        return packageRepository.findById(packageId);
    }

    /**
     * Finds tourPackages based on package cost provided
     *
     * @param cost cost of the tourPackage in the database
     * @return Returns a List of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getByCost(double cost) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findByCost(cost);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("packages with given cost not found");
        }
        return packages;
    }

    /**
     * Finds tourPackages based on package source provided
     *
     * @param source source of the tourPackage in the database
     * @return Returns a List of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getBySource(String source) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findBySource(source);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("packages with given source not found");
        }
        return packages;
    }

    /**
     * Finds tourPackages based on package source and cost provided
     *
     * @param source source of the tourPackage in the database
     * @param cost   cost of the tourPackage in the database
     * @return Returns a List of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getBySourceCost(String source, double cost) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findBySourceCost(source, cost);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("Packages with source and cost not found");
        }
        return packages;
    }

    /**
     * Finds tourPackages based on package destination provided
     *
     * @param destination destination of the tourPackage in the database
     * @return Returns a List of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getByDestination(String destination) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findByDestination(destination);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("Packages with destination not found");
        }
        return packages;
    }

    /**
     * Finds tourPackages based on package source and destination provided
     *
     * @param source      source of the tourPackage in the database
     * @param destination destination of the tourPackage in the database
     * @return Returns a List of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getBySourceDest(String source, String destination) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findBySourceDest(source, destination);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("Packages with source and destination not found");
        }
        return packages;
    }

    /**
     * Finds tourPackages based on airlines name provided
     *
     * @param name name of the airlines in the database
     * @return Returns a List of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getByAirline(String name) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findByAirline(name);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("Packages with gie=ven airline not found");
        }
        return packages;
    }

    /**
     * Finds tourPackages based on package source and airlines provided
     *
     * @param source source of the tourPackages in the database
     * @param name   name of the tourPackages in the database
     * @return Returns a List of tourPackages found in the database
     * @throws PackageNotFoundException If no tourPackage found in the database
     */
    @Override
    public List<TourPackages> getBySourceAirline(String source, String name) throws PackageNotFoundException {
        List<TourPackages> packages = packageRepository.findBySourceAirline(source, name);
        if (packages.isEmpty()) {
            throw new PackageNotFoundException("packages with source and airline not found");
        }
        return packages;
    }
}
