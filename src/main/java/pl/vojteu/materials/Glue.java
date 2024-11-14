package pl.vojteu.materials;

public class Glue extends Material{
    String glueType;

    public Glue(String name, Double price, String unit, String glueType) {
        super(name, price, unit);
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
}
