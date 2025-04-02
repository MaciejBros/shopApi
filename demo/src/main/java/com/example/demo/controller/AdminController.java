package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.model.Order.Order;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.Order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ItemRepository itemRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public AdminController(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    private String adminPage() {
        return "adminview/additem";
    }

    @PostMapping
    private String addItem(Item Item) {
        itemRepository.save(Item);
        return "redirect:/";
    }

    @GetMapping("/showorders")
    @ResponseBody
    public List<Order> showOrders()
    {
        return orderRepository.findAll();
    }
}
