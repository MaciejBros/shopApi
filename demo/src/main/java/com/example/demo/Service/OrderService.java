package com.example.demo.Service;

import com.example.demo.Cart;
import com.example.demo.model.Order.Order;
import com.example.demo.repository.Order.OrderItemRepository;
import com.example.demo.repository.Order.OrderRepository;
import com.example.demo.repository.Order.dto.OrderDto;
import mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(OrderDto orderDto)
    {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order));
        cart.cleanCart();
    }
}
