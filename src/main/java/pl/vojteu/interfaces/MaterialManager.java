package pl.vojteu.interfaces;

import pl.vojteu.materials.Material;

import java.math.BigDecimal;

public interface MaterialManager {
    boolean isMaterialAvailable(Material material, int requiredQuantity);
    String whoIsSupplier(Material material);
}
