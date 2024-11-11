package pl.vojteu;

public class Main {
    public static void main(String[] args) {
        Company company = new Company(new Address("Lubelska", "66E", "Wiazowna", "Mazowieckie"),
                                                    "about us", "Marcin", "Grot");

        InventoryService inventoryService = new InventoryService();

        FurnitureFactoryService factoryService = new FurnitureFactoryService(inventoryService);

        String product = "Chair";
        int quantity = 50;

        boolean isAvailable = factoryService.isProductAvailable(product, quantity);

        if (isAvailable) {
            System.out.println("Produkt " + product + " jest dostępny w ilości " + quantity);
        } else {
            System.out.println("Brakuje wystarczającej ilości produktu " + product + ".");
        }
    }
}