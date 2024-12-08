package pl.vojteu.orders;


import pl.vojteu.entity.Orderer;
import pl.vojteu.products.Product;

import java.util.List;

public class Order {

    private Long id;
    private Orderer orderer;
    private List<Product> products;
    private Integer quantity;
    private String unit;

    public Order(Long id, Orderer orderer, Integer quantity, String unit) {
        this.id = id;
        this.orderer = orderer;
        this.quantity = quantity;
        this.unit = unit;
    }
    public Order(Long id, Orderer orderer) {
        this.id = id;
        this.orderer = orderer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orderer getOrderer() {
        return orderer;
    }

    public void setOrderer(Orderer orderer) {
        this.orderer = orderer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", orderer=" + orderer +
//                ", products=" + products +
//                ", units=" + quantity +
//                '}';
//    }
}
