package com.airlines.exceptions;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public FlightNotFoundException(String message) {
        super(message);
    }
}
