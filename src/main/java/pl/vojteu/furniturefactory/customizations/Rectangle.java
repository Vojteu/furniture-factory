package pl.vojteu.furniturefactory.customizations;

import pl.vojteu.furniturefactory.interfaces.Shape;

public class Rectangle implements Shape {

    @Override
    public void create() {
        System.out.println("Rectangle seat created");
    }
}
