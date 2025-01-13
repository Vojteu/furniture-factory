package pl.vojteu.furniturefactory.materials;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class Glue extends Material {

    private String glueType;
    private final static Logger LOGGER = LogManager.getLogger(Glue.class);

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
        LOGGER.info("This class is named: " + getName() + " and the type is: " + getGlueType());
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