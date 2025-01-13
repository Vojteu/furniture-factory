package pl.vojteu.furniturefactory.customizations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.vojteu.furniturefactory.interfaces.Shape;

public class Circle implements Shape {

    private final static Logger LOGGER = LogManager.getLogger(Circle.class);

    @Override
    public void create() {
        LOGGER.info("Circle seat created");
    }

}
