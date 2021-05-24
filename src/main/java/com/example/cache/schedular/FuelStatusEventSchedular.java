package com.example.cache.schedular;

import com.example.cache.request.FuelStatusRequest;
import com.example.cache.service.kafka.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Channels.class)
public class FuelStatusEventSchedular {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    Channels cnl;

    @Scheduled(fixedDelay = 120000)
    public void scheduleFixedDelayTask() {
        FuelStatusRequest fsr = new FuelStatusRequest("11",false,"Chennai");
        cnl.fuelCostRequest().send(MessageBuilder.withPayload(fsr).build());
    }
}