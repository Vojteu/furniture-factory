package pl.vojteu.products;

import pl.vojteu.Location;
import pl.vojteu.materials.Material;

public abstract class Product {
    private Long id;
    private String name;
    private Double price;
    private Double manufacturingFactor;
    private Location location;
    private Double height;
    private Double width;
    private Material material;
    private String color;

    protected abstract void description();
    protected abstract Double calculateManufacturingCost();

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, Double price, Double manufacturingFactor) {
        this(id, name, price);
        this.manufacturingFactor = manufacturingFactor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getManufacturingFactor() {
        return manufacturingFactor;
    }

    public void setManufacturingFactor(Double manufacturingFactor) {
        this.manufacturingFactor = manufacturingFactor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
