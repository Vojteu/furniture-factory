package pl.vojteu.exceptions.unchecked;

public class InvalidMaterialTypeException extends RuntimeException {

    public InvalidMaterialTypeException(String message) {
        super(message);
    }
}