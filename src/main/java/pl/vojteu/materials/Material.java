package pl.vojteu.materials;

import java.math.BigDecimal;
import java.util.Map;

public abstract class Material {
    private Long id;
    private String name;
    private BigDecimal price;
    private String unit;
    private BigDecimal exchangeRate;
    private Map<String, String> materialSuppliers;

    protected abstract void description();

    public Material(Long id, String name, BigDecimal price, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Map<String, String> getMaterialSuppliers() {
        return materialSuppliers;
    }

    public void setMaterialSuppliers(Map<String, String> materialSuppliers) {
        this.materialSuppliers = materialSuppliers;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }
}
