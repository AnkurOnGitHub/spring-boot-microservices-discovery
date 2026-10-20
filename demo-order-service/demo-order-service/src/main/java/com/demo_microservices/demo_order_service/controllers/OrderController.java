package com.demo_microservices.demo_order_service.controllers;
import com.demo_microservices.demo_order_service.entities.DeliveryOrder;
import com.demo_microservices.demo_order_service.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private @Value("${server.port}") int port;

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<DeliveryOrder>createOrder(@Valid @RequestBody DeliveryOrder deliveryOrder){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(deliveryOrder));
    }

    @GetMapping("/{orderdId}")
    public ResponseEntity<DeliveryOrder>getOrderById(@PathVariable Long orderdId){

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getById(orderdId));
    }

    @GetMapping("/getPort")
    public ResponseEntity<String> getPort() {
        return ResponseEntity.ok("Port is " + port);
    }


}
