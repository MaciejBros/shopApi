package com.example.demo.repository.Order;

import com.example.demo.model.Order.Order;
import com.example.demo.model.Order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{
}