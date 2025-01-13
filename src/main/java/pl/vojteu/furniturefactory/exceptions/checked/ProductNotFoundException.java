package pl.vojteu.furniturefactory.exceptions.checked;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message) {
        super(message);
    }
}
