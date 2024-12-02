package pl.vojteu.stock;

import pl.vojteu.materials.Material;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Long id;
    public static Map<Material, Integer> materials;
    private LocalDateTime lastUpdated;
    private Material material;

    public Inventory() {
        materials = new HashMap<>();
    }

    public Inventory(Long id) {
        this.id = id;
        materials = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public static Map<Material, Integer> getMaterials() {
        return materials;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
