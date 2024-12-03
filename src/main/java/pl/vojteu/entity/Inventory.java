package pl.vojteu.entity;

import pl.vojteu.materials.Material;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private Long id;
    private List<Material> materials;
    public static Map<String, Integer> materialsMap;
    private LocalDateTime lastUpdated;

    public Inventory() {
        materialsMap = new HashMap<>();
    }

    public Inventory(Long id) {
        this.id = id;
        materialsMap = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public static Map<String, Integer> getMaterialsMap() {
        return materialsMap;
    }

    public static void setMaterialsMap(Map<String, Integer> materialsMap) {
        Inventory.materialsMap = materialsMap;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", materials=" + materials +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
