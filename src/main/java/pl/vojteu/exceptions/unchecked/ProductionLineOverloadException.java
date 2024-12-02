    package pl.vojteu.exceptions.unchecked;

public class ProductionLineOverloadException extends Exception {
    public ProductionLineOverloadException(String message) {
        super(message);
    }
}