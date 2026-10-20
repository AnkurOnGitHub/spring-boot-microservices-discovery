package com.demo_microservices.demo_order_service.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class DeliveryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Positive
    @Min(1)
    @Max(50)
    private Integer quantity;

    @Column(nullable = false,name = "order_placed_at")
    @CreationTimestamp
    private LocalDateTime orderPlacedAt;
}
