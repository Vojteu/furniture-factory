package pl.vojteu.orders;

import pl.vojteu.Orderer;
import pl.vojteu.products.Product;

public class RetailerOrder extends Order {

    private Product product;

    public RetailerOrder(Long id, Orderer orderer, Long units, Product product) {
        super(id, orderer, units);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "RetailerOrder{" +
                "product=" + product +
                '}';
    }
}
