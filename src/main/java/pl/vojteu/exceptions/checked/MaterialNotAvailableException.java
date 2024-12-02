package pl.vojteu.exceptions.checked;

//checked exception

public class MaterialNotAvailableException extends Exception {
    public MaterialNotAvailableException(String message) {
        super(message);
    }
}
