package com.airlines.exceptions;

public class AirlineNotFoundException extends  RuntimeException {


    public AirlineNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public AirlineNotFoundException(String message) {
        super(message);
    }
}
