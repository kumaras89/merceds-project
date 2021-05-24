package com.example.cache.request;

import java.io.Serializable;

public class FuelStatusRequest implements Serializable {
    private String carId;
    private boolean lidOpenIndicator;
    private String city;

    public FuelStatusRequest() {

    }
    public FuelStatusRequest(String carId, boolean lidOpenIndicator, String city) {
        this.carId = carId;
        this.lidOpenIndicator = lidOpenIndicator;
        this.city = city;
    }
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public boolean isLidOpenIndicator() {
        return lidOpenIndicator;
    }

    public void setLidOpenIndicator(boolean lidOpenIndicator) {
        this.lidOpenIndicator = lidOpenIndicator;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "FuelStatusRequest{" +
                "carId='" + carId + '\'' +
                ", lidOpenIndicator=" + lidOpenIndicator +
                ", city='" + city + '\'' +
                '}';
    }
}
