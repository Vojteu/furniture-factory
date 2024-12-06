package pl.vojteu.orders;

import pl.vojteu.entity.Orderer;
import pl.vojteu.materials.Material;

public final class MaterialOrder extends Order {

    private Material material;
    private String quantity;

    public MaterialOrder(Long id, Orderer orderer, String quantity, Material material) {
        super(id, orderer);
        this.quantity = quantity;
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MaterialOrder{" +
                "material=" + material +
                ", quantity='" + quantity + '\'' +
                "} " + super.toString();
    }
}
