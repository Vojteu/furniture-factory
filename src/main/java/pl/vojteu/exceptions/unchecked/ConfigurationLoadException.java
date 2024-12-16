package pl.vojteu.exceptions.unchecked;

public class ConfigurationLoadException extends RuntimeException {

    public ConfigurationLoadException(String message) {
        super(message);
    }
}