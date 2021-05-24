package com.example.cache.service.kafka;

import java.util.HashMap;
import java.util.Map;

import com.example.cache.model.CarFuelResponse;
import com.example.cache.model.Fuel;
import com.example.cache.request.FuelStatusRequest;
import com.example.cache.service.FuelCostCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Channels.class)
public class Consumer {
    public static final Map<String,Integer> carRunningTimeMap = new HashMap();
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    FuelCostCalculator fcc;

    @Autowired
    Channels cnl;
    @ServiceActivator(inputChannel = Channels.fuelCostRequest,outputChannel = Channels.fuelCostProcessed)
    public void processFuelRequest(FuelStatusRequest fsr) {
        if(!fsr.isLidOpenIndicator()) {
            caluculateRunningTime(fsr);
        } else {
            Integer runningtime =setRunnignTimeZero(fsr);
            Fuel fuel = fcc.calculateCost(fsr,runningtime);
            logger.info("recieved a complex message : [{}]: {}", fsr);
            logger.info("processed message : [{}]: {}", fuel);
            if(fuel != null) {
                CarFuelResponse cfr = new CarFuelResponse(fsr.getCarId(),fuel);
                cnl.fuelCostProcessed().send(MessageBuilder.withPayload(cfr).build());
            }
        }

    }

    private Integer caluculateRunningTime(FuelStatusRequest fsr) {
        Integer time = carRunningTimeMap.get(fsr.getCarId());
        if(time == null) {
            time = 2;
        } else {
            time = time +2;
        }
         carRunningTimeMap.put(fsr.getCarId(),time);
        return time;
    }

    private Integer setRunnignTimeZero(FuelStatusRequest fsr) {
        Integer time = caluculateRunningTime(fsr);
        carRunningTimeMap.put(fsr.getCarId(),0);
        return time;
    }
}
