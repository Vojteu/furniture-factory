package pl.vojteu.orders;

import pl.vojteu.entity.Order;
import pl.vojteu.entity.Orderer;
import pl.vojteu.materials.Material;

public final class MaterialOrder extends Order {
    private Material material;

    public MaterialOrder(Long id, Orderer orderer, Long units, Material material) {
        super(id, orderer, units);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "MaterialOrder{" +
                "material=" + material +
                '}';
    }
}
