package pl.vojteu.furniturefactory.components;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.vojteu.furniturefactory.materials.Material;

public class Arm extends Component {

    private boolean adjustable;
    private final static Logger LOGGER = LogManager.getLogger(Arm.class);

    public Arm(Material material, boolean adjustable) {
        super(material);
        this.adjustable = adjustable;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    @Override
    public void description() {
        LOGGER.info("Arm: Material = " + getMaterial().getName() + ", Adjustable = " + adjustable);
    }
}
