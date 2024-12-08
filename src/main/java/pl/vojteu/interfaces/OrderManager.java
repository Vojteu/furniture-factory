package pl.vojteu.interfaces;

import pl.vojteu.orders.Order;

public interface OrderManager {
    void addDiscount(Order order, double discount);

    void countOrderCost();
}
