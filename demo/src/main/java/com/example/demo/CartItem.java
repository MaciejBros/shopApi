package com.example.demo;

import com.example.demo.model.Item;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CartItem
{
    private Item item;
    private int counter;
    private BigDecimal price;

    public CartItem(Item item)
    {
        this.item = item;
        this.counter = 1;
        this.price = item.getPrice();
    }

    public void increaseCounter()
    {
        counter++;
        recalculate();
    }

    public void decreaseCouner()
    {
        if(counter>0)
        {
            counter--;
            recalculate();
        }
    }

    private void recalculate()
    {
        price = item.getPrice().multiply(new BigDecimal(counter));
    }

    public boolean hasZeroItems()
    {
        return counter == 0;
    }

    public boolean isEquals(Item item)
    {
        return this.getItem().getId().equals(item.getId());
    }
}
