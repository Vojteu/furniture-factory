package pl.vojteu.products;

public abstract class Product {
    private Long id;
    private String name;
    private Double price;
    private Double manufacturingFactor;

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
}
