package pl.vojteu.customizations;

import pl.vojteu.interfaces.Shape;

public class Rectangle implements Shape {

    @Override
    public void create() {
        System.out.println("Rectangle seat created");
    }
}
