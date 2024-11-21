package pl.vojteu.products;

import pl.vojteu.Location;
import pl.vojteu.interfaces.Adjustable;
import pl.vojteu.interfaces.Customizable;

import java.util.Objects;

public class Chair extends Product implements Adjustable, Customizable {

    private String chairKind;
    private double height;
    private String color;

    public Chair(Long id, String name, Double price, Double manufacturingFactor,  String chairKind) {
        super(id, name, price, manufacturingFactor);
        this.chairKind =  chairKind;
        this.height = 120;
    }

    public String getChairKind() {
        return chairKind;
    }

    public void setChairKind(String chairKind) {
        this.chairKind = chairKind;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    @Override
    protected void description() {
        System.out.println("Chair description");
    }

    @Override
    protected Double calculateManufacturingCost() {
        return getPrice() * getManufacturingFactor();
    }

    @Override
    public void adjustHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "chairKind='" + chairKind + '\'' +
                '}';
    }

    @Override
    public void swing(Location location, double speed) {

    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setDimensions(int width, int height) {

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
}
