package pl.vojteu.interfaces;

import pl.vojteu.products.Product;

public interface ProductManager {
    void addDiscount(Product product, Double discount);
    void whatProductIsThat(Product product);
}
