package com.example.cache.controller;

import com.example.cache.request.FuelStatusRequest;
import com.example.cache.service.FuelCostCalculator;
import com.example.cache.service.kafka.Channels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Channels.class)
public class CarController {

    @Autowired
    FuelCostCalculator fcc;
    @Autowired
    private Channels cnl;

    @PostMapping(value="/fuel-calculator")
    public String pollFuelStatus(@RequestBody FuelStatusRequest fsr) {
        String result = "Processing failed";
        boolean send = cnl.fuelCostRequest().send(MessageBuilder.withPayload(fsr).build());
        if(send) {
            result = "Processing initiated";
        }
        return result;
    }
}
