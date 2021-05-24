package com.example.cache.service;

import com.example.cache.model.Fuel;
import com.example.cache.request.FuelStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelCostCalculatorImpl implements FuelCostCalculator {
    private final FuelCostProvider fcp;
    @Autowired
    FuelCostCalculatorImpl(FuelCostProvider fcp) {
        this.fcp = fcp;
    }
    @Override
    public Fuel calculateCost(FuelStatusRequest fsc, Integer runningtime) {
        Fuel fuel = fcp.getFuelPrice(fsc.getCity());
        // 1 liter for 30 secs
        fuel.setPrice(runningtime*2*fuel.getPrice());
        return fuel;
    }
}
