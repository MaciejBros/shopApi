package com.example.demo.model.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class OrderItem
{
    @Id
    @GeneratedValue
    private Long orderItemId;
    private Long orderId;
    private Long itemId;
    private int amont;

    public OrderItem(Long orderId, Long itemId, int amont) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.amont = amont;
    }
}
