package pl.vojteu.materials;

public class Glue extends Material{
    String glueType;

    public Glue(Long id, String name, Double price, String unit, String glueType) {
        super(id, name, price, unit);
        this.glueType = glueType;
    }

    public String getGlueType() {
        return glueType;
    }

    public void setGlueType(String glueType) {
        this.glueType = glueType;
    }

    @Override
    protected void description() {
        System.out.println("Glue description");
    }

    @Override
    public String toString() {
        return "{id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price='" + super.getPrice() + '\'' +
                ", unit=" + super.getUnit() + '\'' +
                ", glueType='" + glueType + '\'' +
                "}";
    }
}