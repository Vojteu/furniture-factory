package pl.vojteu.customizations;

import pl.vojteu.interfaces.Shape;

public class ShapeCustomization {
    Shape shape;

    public ShapeCustomization(Shape shape) {
        this.shape = shape;
    }

    public void createSeat(Shape shape){
        shape.create();
    }
}
