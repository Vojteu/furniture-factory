package pl.vojteu.furniturefactory.products;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.vojteu.furniturefactory.components.Door;

public class Wardrobe extends Product {

    private String wardrobeKind;
    private Door doors;
    private final static Logger LOGGER = LogManager.getLogger(Wardrobe.class);

    public Wardrobe(Long id, String name, Double price, Double manufacturingFactor, String wardrobeKind, Door doors) {
        super(id, name, price, manufacturingFactor);
        this.wardrobeKind = wardrobeKind;
        this.doors = doors;
    }

    public String getWardrobeKind() {
        return wardrobeKind;
    }

    public void setWardrobeKind(String wardrobeKind) {
        this.wardrobeKind = wardrobeKind;
    }

    public Door getDoors() {
        return doors;
    }

    public void setDoors(Door doors) {
        this.doors = doors;
    }

    @Override
    protected void description() {
        LOGGER.info("Wardrobe description: " + wardrobeKind);
    }

    @Override
    protected Double calculateManufacturingCost() {
        return getPrice() * getManufacturingFactor();
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", wardrobeKind='" + wardrobeKind + '\'' +
                ", doors=" + doors +
                "} ";
    }
}
