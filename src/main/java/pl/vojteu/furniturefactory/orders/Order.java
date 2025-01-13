package pl.vojteu.furniturefactory.orders;

import pl.vojteu.furniturefactory.exceptions.unchecked.InvalidQuantityException;
import pl.vojteu.furniturefactory.entity.Orderer;

public class Order {

    private Long id;
    private Orderer orderer;
    private Integer quantity;
    private String unit;

    public Order(Long id, Orderer orderer, Integer quantity, String unit) throws InvalidQuantityException {
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
}
