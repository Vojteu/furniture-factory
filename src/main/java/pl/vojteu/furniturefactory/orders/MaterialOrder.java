package pl.vojteu.furniturefactory.orders;

import pl.vojteu.furniturefactory.entity.Orderer;
import pl.vojteu.furniturefactory.exceptions.unchecked.InvalidQuantityException;
import pl.vojteu.furniturefactory.materials.Material;

public final class MaterialOrder extends Order {

    private Material material;

    public MaterialOrder(Long id, Orderer orderer, Integer quantity, String unit, Material material) throws InvalidQuantityException {
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
}
