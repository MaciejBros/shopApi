package com.example.demo;

import com.example.demo.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart
{
    private List<CartItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    public void addItem (Item item)
    {
        getCartItemByItem(item).ifPresentOrElse(
                CartItem::increaseCounter,
                ()->cartItems.add(new CartItem(item))
        );
        recalculatePriceAndCoutner();
    }

    public void decreaseItem(Item item)
    {
        Optional<CartItem> oCartItem = getCartItemByItem(item);
        if(oCartItem.isPresent())
        {
            CartItem cartItem = oCartItem.get();
            cartItem.decreaseCouner();
            if (cartItem.hasZeroItems())
            {
                removeAllItems(item);
            } else
            {
                recalculatePriceAndCoutner();
            }
        }
    }

    public void removeAllItems(Item item)
    {
        cartItems.removeIf(i -> i.isEquals(item));
        recalculatePriceAndCoutner();
    }

    private  void recalculatePriceAndCoutner()
    {
        sum = cartItems.stream().map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        counter = cartItems.stream().mapToInt(CartItem::getCounter)
                .reduce(0, Integer::sum);
    }


    private Optional<CartItem> getCartItemByItem(Item item)
    {
        return cartItems.stream()
                .filter(i->i.isEquals(item))
                .findFirst();
    }

    public void cleanCart()
    {
        cartItems.clear();
        counter = 0;
        sum = BigDecimal.ZERO;
    }
}
