package com.demo_microservices.demo_rider_service.entities;
import lombok.*;
import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrder {
    private Long id;
    private String title;
    private Integer quantity;
    private LocalDateTime orderPlacedAt;
}