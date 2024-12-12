package pl.vojteu.interfaces;

import pl.vojteu.orders.Order;
import java.util.List;

public interface OrderManager {
    Double addDiscountOrder(List<Order> order, double discount);
    Double countOrderCost(List<Order> products);
}
