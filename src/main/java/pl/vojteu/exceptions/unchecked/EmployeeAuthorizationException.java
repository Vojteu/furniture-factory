package pl.vojteu.exceptions.unchecked;

public class EmployeeAuthorizationException extends RuntimeException {

    public EmployeeAuthorizationException(String message) {
        super(message);
    }
}