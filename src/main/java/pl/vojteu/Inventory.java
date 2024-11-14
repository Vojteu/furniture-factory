package pl.vojteu;

import pl.vojteu.materials.Material;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inventory {
    private Long id;
    private Material material;
    private Integer quantity;
    private ArrayList<Material> arrayOfMaterials;
    private LocalDate lastUpdated;

    public Inventory() {

    }

    public Inventory(Long id, String name, LocalDate lastUpdated, Material material, Integer quantity) {
        this.id = id;
        this.material = material;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Material> getArrayOfMaterials() {
        return arrayOfMaterials;
    }

    public void setArrayOfMaterials(ArrayList<Material> arrayOfMaterials) {
        this.arrayOfMaterials = arrayOfMaterials;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", material=" + material +
                ", quantity=" + quantity +
                ", arrayOfMaterials=" + arrayOfMaterials +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
