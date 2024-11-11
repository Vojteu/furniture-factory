package pl.vojteu;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<String, Integer> productStock;

    public InventoryService() {
        productStock = new HashMap<String, Integer>();
        productStock.put("Chair", 50);
    }

    public int getProductQuantity(String productName){
        return productStock.getOrDefault(productName, 0);
    }
}
