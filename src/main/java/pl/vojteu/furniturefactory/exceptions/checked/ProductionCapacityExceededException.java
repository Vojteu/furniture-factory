package pl.vojteu.furniturefactory.exceptions.checked;

public class ProductionCapacityExceededException extends Exception {

    public ProductionCapacityExceededException(String message) {
        super(message);
    }
}
