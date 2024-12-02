package pl.vojteu.exceptions.unchecked;

public class ResourceOveruseException extends Exception {
    public ResourceOveruseException(String message) {
        super(message);
    }
}