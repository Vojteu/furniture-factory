package pl.vojteu.furniturefactory.interfaces;

import pl.vojteu.furniturefactory.materials.Material;

public interface MaterialManager {
    boolean isMaterialAvailable(Material material, double requiredQuantity);
    String whoIsSupplier(Material material);
}
