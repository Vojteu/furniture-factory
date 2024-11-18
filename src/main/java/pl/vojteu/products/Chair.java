package pl.vojteu.products;

import java.util.Objects;

public class Chair extends Product {

    private String chairKind;

    public Chair(Long id, String name, Double price, Double manufacturingFactor,  String chairKind) {
        super(id, name, price, manufacturingFactor);
        this.chairKind =  chairKind;
    }

    public String getChairKind() {
        return chairKind;
    }

    public void setChairKind(String chairKind) {
        this.chairKind = chairKind;
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
    public String toString() {
        return "Chair{" +
                "chairKind='" + chairKind + '\'' +
                '}';
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
