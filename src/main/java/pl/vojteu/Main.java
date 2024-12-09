package pl.vojteu;

import pl.vojteu.builders.ChairBuilder;
import pl.vojteu.builders.WardrobeBuilder;
import pl.vojteu.components.Arm;
import pl.vojteu.components.Back;
import pl.vojteu.components.Door;
import pl.vojteu.components.Seat;
import pl.vojteu.customizations.Circle;
import pl.vojteu.customizations.Rectangle;
import pl.vojteu.customizations.ShapeCustomization;
import pl.vojteu.entity.*;
import pl.vojteu.interfaces.Shape;
import pl.vojteu.machines.ChairMachine;
import pl.vojteu.machines.Machine;
import pl.vojteu.machines.WardrobeMachine;
import pl.vojteu.materials.Glue;
import pl.vojteu.materials.Material;
import pl.vojteu.materials.Wood;
import pl.vojteu.orders.MaterialOrder;
import pl.vojteu.orders.Order;
import pl.vojteu.orders.RetailerOrder;
import pl.vojteu.products.Chair;
import pl.vojteu.products.Product;
import pl.vojteu.products.Wardrobe;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        List<Material> materialList = new ArrayList<>();
        List<Machine> machineList = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Map<String, Integer> materialsMap = new HashMap<>();
        Map<String, Integer> materialRequieremtnsMap = new HashMap<>();

        Factory factory = new Factory("Furniture factory");

        Company comp = new Company(new Address("Lubelska", "1", "Warszawa", "Masovian"),
                "decription", "Wojciech", "Salata");
        factory.setCompany(comp);
        final Orderer companyOrderer = new Orderer(1L, "Furniture factory", "sp. z. o. o", comp.getAddress());

        Employee employee1 = new Employee( "Wojciech", "Salata");
        employee1.setAddress(new Address("Lubelska", "1", "Warszawa", "Masovian"));

        Department department1 = new Department(1L, "IT");

        employeeList.add(employee1);
        department1.setEmployeeList(employeeList);
        departmentList.add(department1);

        factory.setEmployees(employeeList);
        factory.setDepartments(departmentList);

        Material material1 = new Glue(1L, "Glue", new BigDecimal(1), "L", "Wood glue");
        Material material2 = new Wood(2L, "Wood", new BigDecimal(1), "kg", "oak");

        materialList.add(material1);
        materialList.add(material2);

        factory.setMaterials(materialList);

        materialsMap.put(material1.getName(), 100);
        materialsMap.put(material2.getName(), 500);
        factory.setLastUpdated(LocalDateTime.now());

        factory.setMaterialsMap(materialsMap);

        Machine machine1 = new ChairMachine(1L, "machine1", "stopped");
        Machine machine2 = new WardrobeMachine(2L, "machine2", "stopped");

        machineList.add(machine1);
        machineList.add(machine2);

        factory.setMachines(machineList);

        Factory.getCurrentStock(materialsMap, factory.getLastUpdated());


        Shape circleShape = new Circle();
        Shape rectangleShape = new Rectangle();

        ShapeCustomization customShape = new ShapeCustomization(rectangleShape);
        Seat seat = new Seat(material2, customShape.getShape());
        Arm arm = new Arm(material2, true);
        Back back = new Back(material2, 40.0);

        Door doors = new Door(material2, customShape.getShape());

        Product product1 = new ChairBuilder()
                .setId(1L)
                .setName("swivel office chair")
                .setPrice(50.0)
                .setManufacturingFactor(1.3)
                .setChairKind("swivel chair")
                .setSeat(seat)
                .setArm(arm)
                .setBack(back)
                .build();

        Product product2 = new WardrobeBuilder()
                .setId(2L)
                .setName("wardrobe big")
                .setPrice(200.0)
                .setManufacturingFactor(0.5)
                .setWardrobeKind("clothes wardrobe")
                .setDoors(doors)
                .build();

        System.out.println();

        System.out.println("prodcut1: " + product1);
        System.out.println("prodcut2: " + product2);
        System.out.println();

        products.add(product1);
        products.add(product2);
        System.out.println(products);

        factory.whatProductIsThat(product1);

        Orderer orderer1 = new Orderer(2L, "Konrad", "Kon", new Address("Zlota",
                "1c", "Warszawa", "Masovian") );
        Order retailerOrder = new RetailerOrder(1L, orderer1, 128, "units", product1);
        factory.addDiscount(product1, 0.2);

        System.out.println(orderer1);
        System.out.println(retailerOrder);

        Supplier supplier = new Supplier(1L, "Jan", "Jakis", materialList);



        Order order1 = new MaterialOrder(1L, companyOrderer, 120, "L", material1);
        Order order2 = new MaterialOrder(2L, companyOrderer, 1000, "kg", material2);

        System.out.println(order1);
        System.out.println(order2);
    }
}