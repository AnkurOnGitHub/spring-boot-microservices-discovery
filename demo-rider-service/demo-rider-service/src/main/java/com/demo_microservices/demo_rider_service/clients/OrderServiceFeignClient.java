package com.demo_microservices.demo_rider_service.clients;
import com.demo_microservices.demo_rider_service.config.OrderSerivceFeignConfig;
import com.demo_microservices.demo_rider_service.entities.DeliveryOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "demo-order-service",configuration = OrderSerivceFeignConfig.class/*url = ""*/)
public interface OrderServiceFeignClient {

    @GetMapping("/order/{orderId}")
    DeliveryOrder getOrderById(@PathVariable Long orderId);

    @GetMapping("/order/getPort")
    String getPort();

}
