package com.demo_microservices.demo_rider_service.config;
import com.demo_microservices.demo_rider_service.decoders.OrderServiceErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderSerivceFeignConfig {
    @Bean
    public ErrorDecoder errorDecoder(){
        return new OrderServiceErrorDecoder();
    }

}
