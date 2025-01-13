package pl.vojteu.furniturefactory.components;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.vojteu.furniturefactory.materials.Material;

public class Back extends Component {

    private double height;
    private final static Logger LOGGER = LogManager.getLogger(Back.class);

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
        LOGGER.info("Back: Material = " + getMaterial().getName() + ", Height = " + height + " cm");
    }
}
