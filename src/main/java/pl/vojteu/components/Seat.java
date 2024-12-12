package pl.vojteu.components;

import pl.vojteu.interfaces.Shape;
import pl.vojteu.materials.Material;

public class Seat extends Component {

    private Shape shape;

    public Seat(Material material, Shape shape) {
        super(material);
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void description() {
        System.out.println("Seat: Material = " + getMaterial().getName() + ", Shape = " + shape.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Seat{" +
                "shape=" + shape.getClass().getSimpleName() +
                "} " + super.toString();
    }
}
