package com.example.cache.model;

import java.io.Serializable;

public class Fuel implements Serializable {
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRateIn() {
        return rateIn;
    }

    public void setRateIn(String rateIn) {
        this.rateIn = rateIn;
    }

    private String rateIn;

    @Override
    public String toString() {
        return "Fuel{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", rateIn='" + rateIn + '\'' +
                '}';
    }
}
