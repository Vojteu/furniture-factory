package pl.vojteu.exceptions.unchecked;

public class ResourceOveruseException extends RuntimeException {

    public ResourceOveruseException(String message) {
        super(message);
    }
}