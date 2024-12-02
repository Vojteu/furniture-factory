package pl.vojteu.exceptions;

public class ProductionCapacityExceededException extends Exception {
    public ProductionCapacityExceededException(String message) {
        super(message);
    }
}
