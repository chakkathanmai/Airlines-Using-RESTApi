package com.airlines.exceptions;

public class PackageNotFoundException extends RuntimeException {
    public PackageNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public PackageNotFoundException(String message) {
        super(message);
    }
}
