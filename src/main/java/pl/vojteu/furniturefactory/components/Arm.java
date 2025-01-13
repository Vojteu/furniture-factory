package pl.vojteu.furniturefactory.components;

import pl.vojteu.furniturefactory.materials.Material;

public class Arm extends Component {

    private boolean adjustable;

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
        System.out.println("Arm: Material = " + getMaterial().getName() + ", Adjustable = " + adjustable);
    }
}
