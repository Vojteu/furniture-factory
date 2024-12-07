package pl.vojteu.builders;

import pl.vojteu.components.Door;
import pl.vojteu.products.Wardrobe;

public class WardrobeBuilder {

    private Long id;
    private String name;
    private Double price;
    private Double manufacturingFactor;
    private String wardrobeKind;
    private Door doors;

    public WardrobeBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public WardrobeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WardrobeBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public WardrobeBuilder setManufacturingFactor(Double manufacturingFactor) {
        this.manufacturingFactor = manufacturingFactor;
        return this;
    }

    public WardrobeBuilder setWardrobeKind(String wardrobeKind) {
        this.wardrobeKind = wardrobeKind;
        return this;
    }

    public WardrobeBuilder setDoors(Door doors) {
        this.doors = doors;
        return this;
    }

    public Wardrobe build() {
        return new Wardrobe(id, name, price, manufacturingFactor, wardrobeKind, doors);
    }
}
