package com.airlines.exceptions;

public class AirlineNotFoundException extends  RuntimeException {


    public AirlineNotFoundException() {
    }

    public AirlineNotFoundException(String message) {
        super(message);
    }
}
