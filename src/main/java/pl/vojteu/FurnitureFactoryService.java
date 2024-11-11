package pl.vojteu;

public class FurnitureFactoryService {
    private InventoryService inventoryService;

    public FurnitureFactoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public boolean isProductAvailable(String productName, int requiredQuantity){
        int availableQuantity = inventoryService.getProductQuantity(productName);
        return availableQuantity >= requiredQuantity;
    }
}
