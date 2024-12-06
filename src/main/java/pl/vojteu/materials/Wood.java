package pl.vojteu.materials;

import pl.vojteu.interfaces.MaterialManager;

import java.math.BigDecimal;
import java.util.Objects;

public class Wood extends Material implements MaterialManager {

    private String woodKind;

    public Wood(Long id, String name, BigDecimal price, String unit, String woodKind) {
        super(id, name, price, unit);
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
    public void adjustPrice(BigDecimal exchangeRate) {
        setPrice((getPrice()).multiply(exchangeRate));
    }

    @Override
    public void whoIsSupplier(Material material) {

    }

    @Override
    public String toString() {
        return "{id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price='" + super.getPrice() + '\'' +
                ", unit=" + super.getUnit() + '\'' +
                ", woodKind='" + woodKind + '\'' +
                "}";
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
