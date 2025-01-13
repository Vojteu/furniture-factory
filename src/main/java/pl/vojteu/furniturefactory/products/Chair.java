package pl.vojteu.furniturefactory.products;

import pl.vojteu.furniturefactory.components.Seat;
import pl.vojteu.furniturefactory.components.Arm;
import pl.vojteu.furniturefactory.components.Back;

import java.util.Objects;

public class Chair extends Product{

    private String chairKind;
    private Seat seat;
    private Arm arm;
    private Back back;
    private boolean massageMode;

    public Chair(Long id, String name, Double price, Double manufacturingFactor, String chairKind, Seat seat, Arm arm, Back back) {
        super(id, name, price, manufacturingFactor);
        this.chairKind = chairKind;
        this.seat = seat;
        this.arm = arm;
        this.back = back;
    }

    public String getChairKind() {
        return chairKind;
    }

    public void setChairKind(String chairKind) {
        this.chairKind = chairKind;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Arm getArm() {
        return arm;
    }

    public void setArm(Arm arm) {
        this.arm = arm;
    }

    public Back getBack() {
        return back;
    }

    public void setBack(Back back) {
        this.back = back;
    }

    public boolean isMassageMode() {
        return massageMode;
    }

    public void setMassageMode(boolean massageMode) {
        this.massageMode = massageMode;
    }

    @Override
    protected void description() {
        System.out.println("Chair description:");
        if (seat != null) seat.description();
        if (arm != null) arm.description();
        if (back != null) back.description();
    }

    @Override
    protected Double calculateManufacturingCost() {
        return getPrice() * getManufacturingFactor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return Objects.equals(chairKind, chair.chairKind);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chairKind);
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", chairKind='" + chairKind + '\'' +
                ", seat=" + seat +
                ", arm=" + arm +
                ", back=" + back +
                "} " ;
    }
}
