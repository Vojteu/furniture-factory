package pl.vojteu.products;

public class Wardrobe extends Product{
    String wardrobeKind;

    public Wardrobe(Long id, String name, Double price, Double manufacturingFactor, String wardrobeKind) {
        super(id, name, price, manufacturingFactor);
        this.wardrobeKind = wardrobeKind;
    }

    public String getWardrobeKind() {
        return wardrobeKind;
    }

    public void setWardrobeKind(String wardrobeKind) {
        this.wardrobeKind = wardrobeKind;
    }

    @Override
    protected void description() {
        System.out.println("Wardrobe description");
    }

    @Override
    protected Double calculateManufacturingCost() {
        return getPrice() * getManufacturingFactor();
    }

    @Override
    public String toString() {
        return "Wardrobe{" +
                "wardrobeKind='" + wardrobeKind + '\'' +
                '}';
    }
}
