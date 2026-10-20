package com.demo_microservices.demo_rider_service.decoders;

import com.demo_microservices.demo_rider_service.exception.ResourceNotFountException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class OrderServiceErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultDecoder = new Default();
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 404:
                return new ResourceNotFountException(response.reason());
            default:
                return defaultDecoder.decode(methodKey,response);
        }

    }
}
