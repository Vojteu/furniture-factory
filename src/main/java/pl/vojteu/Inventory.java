package pl.vojteu;

import pl.vojteu.materials.Material;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Long id;
    public static Map<Material, Integer> materials;
    private LocalDate lastUpdated;

    public Inventory() {
        materials = new HashMap<>();
    }

    public Inventory(Long id, LocalDate lastUpdated) {
        this.id = id;
        this.lastUpdated = lastUpdated;
        materials = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public static Map<Material, Integer> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material, int quantity) {
        materials.put(material, materials.getOrDefault(material, 0) + quantity);
    }

    public void updateQuantity(Material material, int quantity) {
        materials.put(material, quantity);
    }

//    public void getCurrentStock() {
//        System.out.println("The current stock of materials is:");
//        for(Material material : materials.keySet() ){
//            System.out.println(material.getName() + " " +
//                    materials.getOrDefault(material, 0) + " " + material.getUnit());
//        }
//    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
