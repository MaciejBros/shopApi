package com.example.demo.controller;

import com.example.demo.ItemOperation;
import com.example.demo.Service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {

    private final CartService cartService;

    public HomeController(CartService cartService)
    {
        this.cartService = cartService;
    }


    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    }

    @GetMapping("/add/{itemId}")
    public String addItemCart(@PathVariable("itemId") Long itemId, Model model)
    {
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        model.addAttribute("items", cartService.getAllItems());
        return "redirect:/";
    }
}
