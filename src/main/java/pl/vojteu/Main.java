package pl.vojteu;

import pl.vojteu.materials.Material;
import pl.vojteu.materials.Wood;
import pl.vojteu.orders.MaterialOrder;
import pl.vojteu.orders.Order;
import pl.vojteu.orders.RetailerOrder;
import pl.vojteu.products.Chair;
import pl.vojteu.products.Product;
import pl.vojteu.products.Wardrobe;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company company = new Company(new Address("Olkiewicza", "66", "Warsaw", "Masovian"), "about us", "Marcin", "Grot");

        System.out.println(company);

        Material material = new Wood("Wood", 1.0, "kg", "oak");

        Order order1 = new MaterialOrder(1L, (new Orderer(1L, "Wojtek", "S",
                new Address("Olkiewicza", "66", "Warsaw", "Masovian"))), 100L, material);


        Product product2 = new Chair(1L, "swivel office chair", 50.0, 0.6, "swivel chair");

        Order order2 = new RetailerOrder(1L, new Orderer(1L, "Wojtek", "S",
                new Address("Olkiewicza", "66", "Warsaw", "Masovian")), 150L, product2);

        System.out.println(order1);
        System.out.println(order2);

        Inventory inventory = new Inventory();
        ArrayList<Material> array = new ArrayList<Material>();
        array.add(material);
        inventory.setArrayOfMaterials(array);
        inventory.getArrayOfMaterials();

        System.out.println(inventory);
    }
}
