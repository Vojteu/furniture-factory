package pl.vojteu.furniturefactory.interfaces;

import pl.vojteu.furniturefactory.products.Product;

public interface ProductManager {
    void addDiscount(Product product, Double discount);
    void whatProductIsThat(Product product);
}
