package pl.vojteu.furniturefactory.orders;

import pl.vojteu.furniturefactory.entity.Orderer;
import pl.vojteu.furniturefactory.exceptions.unchecked.InvalidQuantityException;
import pl.vojteu.furniturefactory.products.Product;

public final class RetailerOrder extends Order {

    private Product product;

    public RetailerOrder(Long id, Orderer orderer, Integer quantity, String unit, Product product) throws InvalidQuantityException {
        super(id, orderer, quantity, unit);
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
                '}' + " quantity: " + getQuantity() + getUnit();
    }
}
