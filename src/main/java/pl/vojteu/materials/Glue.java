package pl.vojteu.materials;

import pl.vojteu.interfaces.MaterialManager;

import java.math.BigDecimal;

public class Glue extends Material implements MaterialManager {

    String glueType;

    public Glue(Long id, String name, BigDecimal price, String unit, String glueType) {
        super(id, name, price, unit);
        this.glueType = glueType;
    }

    public String getGlueType() {
        return glueType;
    }

    public void setGlueType(String glueType) {
        this.glueType = glueType;
    }

    @Override
    public void whoIsSupplier(Material material) {

    }

    @Override
    protected void description() {
        System.out.println("Glue description");
    }

    @Override
    public void adjustPrice(BigDecimal exchangeRate) {
        setPrice((getPrice()).multiply(exchangeRate));
    }

    @Override
    public String toString() {
        return "{id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price='" + super.getPrice() + '\'' +
                ", unit=" + super.getUnit() + '\'' +
                ", glueType='" + glueType + '\'' +
                "}";
    }
}