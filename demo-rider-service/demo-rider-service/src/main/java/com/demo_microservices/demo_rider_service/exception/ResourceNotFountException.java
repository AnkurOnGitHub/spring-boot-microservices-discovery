package com.demo_microservices.demo_rider_service.exception;
public class ResourceNotFountException extends RuntimeException{
    public ResourceNotFountException(String message) {
        super(message);
    }
}
