package pl.vojteu.exceptions.unchecked;

public class ProductionLineOverloadException extends RuntimeException {

    public ProductionLineOverloadException(String message) {
        super(message);
    }
}