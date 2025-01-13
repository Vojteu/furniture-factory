package pl.vojteu.furniturefactory.machines;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WardrobeMachine extends Machine {

    private static final Integer workStation = 2;
    private final static Logger LOGGER = LogManager.getLogger(WardrobeMachine.class);

    public WardrobeMachine(Long id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void build() {
        LOGGER.info("build wardrobe");
    }
}
