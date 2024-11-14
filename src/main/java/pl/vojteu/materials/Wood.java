package pl.vojteu.materials;

import java.util.Objects;

public class Wood extends Material {
    String woodKind;

    public Wood(String name, Double price, String unit, String woodKind) {
        super(name, price, unit);
        this.woodKind = woodKind;
    }

    public String getWoodKind() {
        return woodKind;
    }

    public void setWoodKind(String woodKind) {
        this.woodKind = woodKind;
    }

    @Override
    protected void description() {
        System.out.println("Wood description");
    }

    @Override
    public String toString() {
        return "Wood{" +
                "woodKind='" + woodKind + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wood wood = (Wood) o;
        return Objects.equals(woodKind, wood.woodKind);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(woodKind);
    }
}
