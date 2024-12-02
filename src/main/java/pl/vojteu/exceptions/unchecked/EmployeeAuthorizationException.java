package pl.vojteu.exceptions.unchecked;

public class EmployeeAuthorizationException extends Exception {
    public EmployeeAuthorizationException(String message) {
        super(message);
    }
}