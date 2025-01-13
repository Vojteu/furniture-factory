package pl.vojteu.furniturefactory.builders;

import pl.vojteu.furniturefactory.components.Arm;
import pl.vojteu.furniturefactory.components.Back;
import pl.vojteu.furniturefactory.components.Seat;
import pl.vojteu.furniturefactory.products.Chair;

public class ChairBuilder {

    private Long id;
    private String name;
    private Double price;
    private Double manufacturingFactor;
    private String chairKind;
    private Seat seat;
    private Arm arm;
    private Back back;

    public ChairBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ChairBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ChairBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public ChairBuilder setManufacturingFactor(Double manufacturingFactor) {
        this.manufacturingFactor = manufacturingFactor;
        return this;
    }

    public ChairBuilder setChairKind(String chairKind) {
        this.chairKind = chairKind;
        return this;
    }

    public ChairBuilder setSeat(Seat seat) {
        this.seat = seat;
        return this;
    }

    public ChairBuilder setArm(Arm arm) {
        this.arm = arm;
        return this;
    }

    public ChairBuilder setBack(Back back) {
        this.back = back;
        return this;
    }

    public Chair build() {
        return new Chair(id, name, price, manufacturingFactor, chairKind, seat, arm, back);
    }
}
