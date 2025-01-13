package pl.vojteu.furniturefactory.components;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.vojteu.furniturefactory.interfaces.Shape;
import pl.vojteu.furniturefactory.materials.Material;

public class Door extends Component {

    private Shape shape;
    private final static Logger LOGGER = LogManager.getLogger(Door.class);

    public Door(Material material, Shape shape) {
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
        LOGGER.info("Door: Material = " + getMaterial().getName() + ", Shape = " + shape.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Door{" +
                "shape=" + shape.getClass().getSimpleName() +
                "} " + super.toString();
    }
}
