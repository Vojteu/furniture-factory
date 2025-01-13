package pl.vojteu.furniturefactory.interfaces;

import pl.vojteu.furniturefactory.orders.Order;

import java.util.List;

public interface OrderManager {
    Double addDiscountOrder(List<Order> order, double discount);
    Double countOrderCost(List<Order> products);
}
