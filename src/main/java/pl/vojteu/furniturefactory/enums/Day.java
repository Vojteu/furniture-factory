package pl.vojteu.furniturefactory.enums;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public enum Day {

    MONDAY("Start of the work week"),
    FRIDAY("End of the work week"),
    SATURDAY("First day of the weekend"),
    SUNDAY("Second day of the weekend");

    private final static Logger LOGGER = LogManager.getLogger(Day.class);
    private final String description;

    Day(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printGreeting() {
        switch (this) {
            case MONDAY -> LOGGER.info("Ugh, it's Monday. Let's get to work!");
            case FRIDAY -> LOGGER.info("It's Friday! Weekend is near!");
            case SATURDAY -> LOGGER.info("It's Saturday.");
            case SUNDAY -> LOGGER.info("Relax, it's Sunday.");
            default -> LOGGER.info("Have a great day!");
        }
    }
}