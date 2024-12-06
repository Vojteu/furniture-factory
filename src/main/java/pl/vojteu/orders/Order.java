package pl.vojteu.orders;


import pl.vojteu.entity.Orderer;
import pl.vojteu.products.Product;

import java.util.List;

public class Order {

    private Long id;
    private Orderer orderer;
    private List<Product> products;
    private Long units;

    public Order(Long id, Orderer orderer, Long units) {
        this.id = id;
        this.orderer = orderer;
        this.units = units;
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

    public Long getUnits() {
        return units;
    }

    public void setUnits(Long units) {
        this.units = units;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderer=" + orderer +
                ", products=" + products +
                ", units=" + units +
                '}';
    }
}
