package pl.vojteu;

import pl.vojteu.customizations.Circle;
import pl.vojteu.customizations.Rectangle;
import pl.vojteu.customizations.ShapeCustomization;
import pl.vojteu.exceptions.MaterialNotAvailableException;
import pl.vojteu.interfaces.Shape;
import pl.vojteu.materials.Glue;
import pl.vojteu.materials.Material;
import pl.vojteu.materials.Wood;
import pl.vojteu.orders.MaterialOrder;
import pl.vojteu.orders.Order;
import pl.vojteu.utils.*;
import pl.vojteu.orders.RetailerOrder;
import pl.vojteu.products.Chair;
import pl.vojteu.products.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, MaterialNotAvailableException {
//        Address companyAddress = new Address("Olkiewicza", "66", "Warsaw", "Masovian");
//        Company company = new Company(companyAddress,"about us", "Marcin", "Grot");
//
//        System.out.println(company);
//
//        Department department1 = new Department(1L, "IT department");
//
//        Employee employee1 = new Employee(1L, "Adrian", "Wysocki",
//                new Address("Lubelska","11", "Wroclaw", "Dolnoslaskie"));
//
//        Employee employee2 = new Employee(2L, "Karol", "Gad",
//                new Address("Wojcickiego","12", "Warszawa", "Mazowieckie"));
//
//        department1.setEmployees(new Employee[]{employee1, employee2});
//
//        System.out.println(department1);
//

//
//        Material material1 = new Wood(1L,"Wood", new BigDecimal(1), "kg", "oak");
//        Material material2 = new Glue(2L,"Glue", new BigDecimal(1), "ml", "Wood glue");
//
//        System.out.println();
//        Inventory inventory = new Inventory();
//
//        inventory.addMaterial(material1.getName(),250);
//        inventory.getLastUpdated();
//        inventory.addMaterial(material2.getName(),700);

//        System.out.println(inventory.getLastUpdated());
        //        System.out.println(inventory.getMaterials());
//        System.out.println();
//
//        Factory factory = new Factory();
//        factory.getCurrentStock(inventory.getMaterials());
//
//        System.out.println();
//
//
//        Order order1 = new MaterialOrder(1L, (new Orderer(1L, "Wojtek", "S",
//                new Address("Olkiewicza", "66", "Warsaw", "Masovian"))), 100L, material1);
//
//        Product product2 = new Chair(1L, "swivel office chair", 50.0, 0.6, "swivel chair");
//
//        Order order2 = new RetailerOrder(1L, new Orderer(1L, "Wojtek", "S",
//                new Address("Olkiewicza", "66", "Warsaw", "Masovian")), 150L, product2);
//
//        System.out.println(order1);
//        System.out.println(order2);
//
//        Shape circleSeat = new Circle();
//        Shape rectangleSeat = new Rectangle();
//
//        ShapeCustomization seatPreference = new ShapeCustomization(circleSeat);
//        seatPreference.createSeat(circleSeat);
//        seatPreference.createSeat(rectangleSeat);
//
        System.out.println(Factory.readNoteFile("src/main/resources/note.txt"));

        Factory factory = new Factory();
        Inventory inventory = new Inventory();
        Map<Material, Integer> materialsList = new HashMap<>();

        materialsList.put(new Wood(1L,"Wood", new BigDecimal(1), "kg", "oak"), 100);
        materialsList.put(new Glue(2L,"Glue", new BigDecimal(1), "ml", "Wood glue"), 2000);
        Factory.getCurrentStock(materialsList);

        inventory.materials = materialsList;
        System.out.println(inventory.getMaterials());


    }
}
