package pl.vojteu.furniturefactory.enums;

public enum Day {

    MONDAY("Start of the work week"),
    FRIDAY("End of the work week"),
    SATURDAY("First day of the weekend"),
    SUNDAY("Second day of the weekend");

    private final String description;

    Day(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printGreeting() {
        switch (this) {
            case MONDAY -> System.out.println("Ugh, it's Monday. Let's get to work!");
            case FRIDAY -> System.out.println("It's Friday! Weekend is near!");
            case SATURDAY -> System.out.println("It's Saturday.");
            case SUNDAY -> System.out.println("Relax, it's Sunday.");
            default -> System.out.println("Have a great day!");
        }
    }
}