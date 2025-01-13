package pl.vojteu.furniturefactory.machines;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChairMachine extends Machine {

    private static final Integer workStation = 1;
    private final static Logger LOGGER = LogManager.getLogger(ChairMachine.class);

    public ChairMachine(Long id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void build() {
        LOGGER.info("build chair");
    }
}
