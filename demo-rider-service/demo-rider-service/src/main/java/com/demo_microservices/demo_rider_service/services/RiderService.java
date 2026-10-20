package com.demo_microservices.demo_rider_service.services;
import com.demo_microservices.demo_rider_service.clients.OrderServiceFeignClient;
import com.demo_microservices.demo_rider_service.entities.DeliveryOrder;
import com.demo_microservices.demo_rider_service.exception.ResourceNotFountException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class RiderService {
    private final RestClient restClient;
    private final OrderServiceFeignClient orderServiceFeignClient;

    public DeliveryOrder getOrderForRider(Long orderId) {
        try{
            return orderServiceFeignClient.getOrderById(orderId);

        }catch (FeignException.NotFound ex){
            throw new ResourceNotFountException("Order not found by id "+ orderId);
        }catch (FeignException ex){
            throw new RuntimeException("Server error");
        }
//        return restClient
//                .get()
//                .uri("/order/{orderId}",orderId)
//                .retrieve()
//                .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{ throw new RuntimeException("Oder not found "+res.getStatusCode());})
//                .onStatus(HttpStatusCode::is5xxServerError,(req,res)->{ throw new RuntimeException("Server Error1");})
//                .body(DeliveryOrder.class);
    }
    public DeliveryOrder create(DeliveryOrder deliveryOrder) {
        return restClient
                .post()
                .uri("/order/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(deliveryOrder)
                .retrieve()
                .body(DeliveryOrder.class);

    }

    public String checkPort() {
        return orderServiceFeignClient.getPort();
    }
}
