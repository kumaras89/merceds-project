package com.example.cache.service.kafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@Configuration
public interface Channels {
    public static final String fuelCostRequest ="fuel-cost-request";

    public static final String fuelCostProcessed ="fuel-processed";
    @Output(fuelCostRequest)
    MessageChannel fuelCostRequest();

    @Output(fuelCostProcessed)
    MessageChannel fuelCostProcessed();

    @Input(fuelCostRequest)
    SubscribableChannel fuelCostRequestListener();
}
