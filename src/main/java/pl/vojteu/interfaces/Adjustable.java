package pl.vojteu.interfaces;

import pl.vojteu.products.Product;

public interface Adjustable {
    boolean heatedSeat(boolean mode, Product product);
    boolean massageMode(boolean mode, Product product);
}
