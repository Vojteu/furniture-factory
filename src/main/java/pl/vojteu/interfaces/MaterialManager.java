package pl.vojteu.interfaces;

import pl.vojteu.materials.Material;

import java.math.BigDecimal;

public interface MaterialManager {
    void adjustPrice(BigDecimal bigdecimal);
    void whoIsSupplier(Material material);
}
