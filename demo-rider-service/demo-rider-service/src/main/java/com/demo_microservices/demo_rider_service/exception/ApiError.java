package com.demo_microservices.demo_rider_service.exception;

import java.time.Instant;

public record ApiError(
        Instant timespace,
        int status,
        String error,
        String message,
        String path
) {
}
