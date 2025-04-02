package mapper;

import com.example.demo.Cart;
import com.example.demo.CartItem;
import com.example.demo.model.Order.Order;
import com.example.demo.model.Order.OrderItem;
import com.example.demo.repository.Order.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
    public static Order mapToOrder(OrderDto orderDto)
    {
        return Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postCode(orderDto.getPostCode())
                .city(orderDto.getCity())
                .created(LocalDateTime.now())
                .build();
    }

    public static List<OrderItem> mapToOrderItemList(Cart cart, Order order)
    {
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem ci : cart.getCartItems())
        {
            orderItems.add(new OrderItem(order.getOrderId(), ci.getItem().getId(), ci.getCounter()));
        }
        return orderItems;
    }
}
