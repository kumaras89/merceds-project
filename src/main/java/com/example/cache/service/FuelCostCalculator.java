package com.example.cache.service;

import com.example.cache.model.Fuel;
import com.example.cache.request.FuelStatusRequest;

public interface FuelCostCalculator {
    public Fuel calculateCost(FuelStatusRequest fsc, Integer runningtime);
}