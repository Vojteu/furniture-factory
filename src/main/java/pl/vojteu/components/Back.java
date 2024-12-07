package pl.vojteu.components;

import pl.vojteu.materials.Material;

public class Back extends Component {
    private double height;

    public Back(Material material, double height) {
        super(material);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void description() {
        System.out.println("Back: Material = " + getMaterial().getName() + ", Height = " + height + " cm");
    }
}
