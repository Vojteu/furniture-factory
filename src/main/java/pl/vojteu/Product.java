package pl.vojteu;

public class Product {
    private Long id;
    private String name;
    private String productType;
    private Material material;
    private Double dimension;
    private Double price;
    private Double manufacturingCost;

    public Product(String name, String productType, Material material, Double dimension, Double price, Double manufacturingCost) {
        this.name = name;
        this.productType = productType;
        this.material = material;
        this.dimension = dimension;
        this.price = price;
        this.manufacturingCost = manufacturingCost;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Double getDimension() {
        return dimension;
    }

    public void setDimension(Double dimension) {
        this.dimension = dimension;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getManufacturingCost() {
        return manufacturingCost;
    }

    public void setManufacturingCost(Double manufacturingCost) {
        this.manufacturingCost = manufacturingCost;
    }
}
