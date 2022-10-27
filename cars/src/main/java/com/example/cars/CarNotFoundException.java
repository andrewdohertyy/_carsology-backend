package com.example.cars;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException() {
        super("Car has not been found");
    }
}

