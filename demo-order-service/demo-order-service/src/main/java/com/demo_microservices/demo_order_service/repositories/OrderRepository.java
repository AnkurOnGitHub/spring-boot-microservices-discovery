package com.demo_microservices.demo_order_service.repositories;
import com.demo_microservices.demo_order_service.entities.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<DeliveryOrder, Long> {
}
