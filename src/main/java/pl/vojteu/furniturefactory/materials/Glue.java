package pl.vojteu.furniturefactory.materials;

import java.math.BigDecimal;

public class Glue extends Material {

    private String glueType;

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
    public void description() {
        System.out.println("This class is named: " + getName() + " and the type is: " + getGlueType());
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