package com.demo_microservices.demo_order_service.services;

import com.demo_microservices.demo_order_service.entities.DeliveryOrder;
import com.demo_microservices.demo_order_service.excetion.ResourceNotFoundException;
import com.demo_microservices.demo_order_service.repositories.OrderRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public DeliveryOrder createOrder(DeliveryOrder deliveryOrder) {
        return orderRepository.save(deliveryOrder);
    }

    public DeliveryOrder getById(Long orderdId) {
        return orderRepository.findById(orderdId).orElseThrow(()->new ResourceNotFoundException("Order does not exist by id " + orderdId));
    }

}
