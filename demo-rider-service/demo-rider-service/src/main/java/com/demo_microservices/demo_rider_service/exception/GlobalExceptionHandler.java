    package com.demo_microservices.demo_rider_service.exception;

    import jakarta.servlet.http.HttpServletRequest;
    import org.springframework.http.HttpRequest;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.RestControllerAdvice;

    import java.time.Instant;

    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(ResourceNotFountException.class)
        public ResponseEntity<ApiError>resourceNotFound(HttpServletRequest req, ResourceNotFountException ex){
            ApiError apiError = new ApiError(Instant.now(), 404,"Resource Not Found",ex.getLocalizedMessage(),req.getRequestURI());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }
    }
