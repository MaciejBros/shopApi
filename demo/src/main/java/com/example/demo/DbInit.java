package com.example.demo;

import com.example.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ItemRepository itemRepository;

    @Autowired
    public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
            new Item("IPhone 20 pro max", new BigDecimal("7999.99"), "https://image.ceneostatic.pl/data/products/157145034/i-apple-iphone-15-256gb-niebieski.jpg"),
            new Item("Samsung Galaxy S20 ", new BigDecimal("4999.99"), "https://image.ceneostatic.pl/data/products/163090033/i-samsung-galaxy-s24-sm-s921-8-256gb-czarny.jpg"),
            new Item("Xiaomi MI 8", new BigDecimal("1999.99"), "https://image.ceneostatic.pl/data/products/161119938/i-xiaomi-14-pro-16-512gb-czarny.jpg")
        ));
    }
}
