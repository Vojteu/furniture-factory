package pl.vojteu.products;

public abstract class Product {

    private Long id;
    private String name;
    private Double price;
    private Double height;
    private Double width;
    private String color;
    private Double manufacturingFactor;

    protected abstract void description();

    protected abstract Double calculateManufacturingCost();

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = "Brown";
        this.width = 60.0;
        this.height = 100.0;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", height=" + height +
                ", width=" + width +
                ", color='" + color + '\'' +
                ", manufacturingFactor=" + manufacturingFactor +
                '}';
    }
}
