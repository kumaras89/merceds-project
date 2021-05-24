package com.example.cache.model;

import java.io.Serializable;

public class CarFuelResponse implements Serializable {
    private String carId;
    private Fuel fuel;
    public CarFuelResponse(String carId , Fuel fuel) {
        this.carId =carId;
        this.fuel = fuel;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
