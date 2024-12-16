package pl.vojteu.interfaces;

import pl.vojteu.materials.Material;

public interface MaterialManager {
    boolean isMaterialAvailable(Material material, double requiredQuantity);
    String whoIsSupplier(Material material);
}
