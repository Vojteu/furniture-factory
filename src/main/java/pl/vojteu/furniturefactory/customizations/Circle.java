package pl.vojteu.furniturefactory.customizations;

import pl.vojteu.furniturefactory.interfaces.Shape;

public class Circle implements Shape {

    @Override
    public void create() {
        System.out.println("Circle seat created");
    }

}
