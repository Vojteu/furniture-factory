package pl.vojteu.furniturefactory.interfaces;

import pl.vojteu.furniturefactory.products.Product;

public interface Adjustable {
    boolean heatedSeat(boolean mode, Product product);
    boolean massageMode(boolean mode, Product product);
}
