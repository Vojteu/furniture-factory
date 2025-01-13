package pl.vojteu.furniturefactory.components;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.vojteu.furniturefactory.interfaces.Shape;
import pl.vojteu.furniturefactory.materials.Material;

public class Seat extends Component {

    private Shape shape;
    private final static Logger LOGGER = LogManager.getLogger(Seat.class);

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
        LOGGER.info("Seat: Material = " + getMaterial().getName() + ", Shape = " + shape.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Seat{" +
                "shape=" + shape.getClass().getSimpleName() +
                "} " + super.toString();
    }
}
