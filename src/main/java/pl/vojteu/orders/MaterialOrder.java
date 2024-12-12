package pl.vojteu.orders;

import pl.vojteu.entity.Orderer;
import pl.vojteu.interfaces.MaterialManager;
import pl.vojteu.materials.Material;

import java.math.BigDecimal;

public final class MaterialOrder extends Order implements MaterialManager {

    private Material material;

    public MaterialOrder(Long id, Orderer orderer, Integer quantity, String unit, Material material) {
        super(id, orderer, quantity,unit);
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
                "} " + "quantity: " + getQuantity() + getUnit();
    }

    @Override
    public boolean isMaterialAvailable(Material material, int requiredQuantity) {
        return false;
    }

    @Override
    public String whoIsSupplier(Material material) {
        return material.getMaterialSuppliers().get(material.getName());
    }
}
