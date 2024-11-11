package pl.vojteu;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Inventory {
    private Long id;
    private LocalDate lastUpdated;
    private Material material;
    private Integer quantity;
    private LocalDateTime localDateTime;

    public Inventory(LocalDate lastUpdated, Integer quantity, Material material, LocalDateTime localDateTime) {
        this.lastUpdated = lastUpdated;
        this.quantity = quantity;
        this.material = material;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
