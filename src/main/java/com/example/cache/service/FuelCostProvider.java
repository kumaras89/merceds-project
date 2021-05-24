package com.example.cache.service;

import com.example.cache.model.Fuel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="fuel", url = "localhost:8097")
public interface FuelCostProvider {
    @Cacheable(value = "fuel-price", key = "#cityName")
    @RequestMapping(method = RequestMethod.GET, value = "/fuel-prices")
    Fuel getFuelPrice(@RequestParam String cityName);
}
