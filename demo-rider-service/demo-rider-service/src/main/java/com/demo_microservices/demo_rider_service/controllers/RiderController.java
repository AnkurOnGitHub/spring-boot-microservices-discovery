package com.demo_microservices.demo_rider_service.controllers;

import com.demo_microservices.demo_rider_service.entities.DeliveryOrder;
import com.demo_microservices.demo_rider_service.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<DeliveryOrder>getOrderById(@PathVariable Long orderId){
        final DeliveryOrder order = riderService.getOrderForRider(orderId);
        return ResponseEntity.ok(order);
    }
    @PostMapping("/create-order")
    public ResponseEntity<DeliveryOrder>createOrder(@RequestBody DeliveryOrder deliveryOrder){
        return ResponseEntity.status(HttpStatus.CREATED).body(riderService.create(deliveryOrder));
    }

    @GetMapping("/check-order-port")
    public ResponseEntity<String>checkOrderPort(){
        return ResponseEntity.status(HttpStatus.OK).body(riderService.checkPort());
    }


}
