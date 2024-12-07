package pl.vojteu.customizations;

import pl.vojteu.interfaces.Shape;

public class ShapeCustomization {

    private Shape shape;
    private double width;
    private double height;

    public ShapeCustomization(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void createSeat(Shape shape) {
        shape.create();
    }

    @Override
    public String toString() {
        return "ShapeCustomization{" +
                "shape=" + shape +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
