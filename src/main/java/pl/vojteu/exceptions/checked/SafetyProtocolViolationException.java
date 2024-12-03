package pl.vojteu.exceptions.checked;

public class SafetyProtocolViolationException extends Exception {

    public SafetyProtocolViolationException(String message) {
        super(message);
    }
}
