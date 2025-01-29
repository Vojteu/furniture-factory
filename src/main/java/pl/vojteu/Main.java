package pl.vojteu;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pl.vojteu.furniturefactory.Factory;
import pl.vojteu.furniturefactory.builders.ChairBuilder;
import pl.vojteu.furniturefactory.builders.WardrobeBuilder;
import pl.vojteu.furniturefactory.components.Arm;
import pl.vojteu.furniturefactory.components.Back;
import pl.vojteu.furniturefactory.components.Door;
import pl.vojteu.furniturefactory.components.Seat;
import pl.vojteu.furniturefactory.customizations.Circle;
import pl.vojteu.furniturefactory.customizations.Rectangle;
import pl.vojteu.furniturefactory.customizations.ShapeCustomization;
import pl.vojteu.furniturefactory.entity.*;
import pl.vojteu.furniturefactory.exceptions.checked.MachineNotFoundException;
import pl.vojteu.furniturefactory.exceptions.checked.MaterialNotAvailableException;
import pl.vojteu.furniturefactory.exceptions.checked.ProductNotFoundException;
import pl.vojteu.furniturefactory.exceptions.checked.ProductionCapacityExceededException;
import pl.vojteu.furniturefactory.exceptions.unchecked.InvalidQuantityException;
import pl.vojteu.furniturefactory.interfaces.Shape;
import pl.vojteu.furniturefactory.machines.ChairMachine;
import pl.vojteu.furniturefactory.machines.Machine;
import pl.vojteu.furniturefactory.machines.WardrobeMachine;
import pl.vojteu.furniturefactory.materials.Glue;
import pl.vojteu.furniturefactory.materials.Material;
import pl.vojteu.furniturefactory.materials.Wood;
import pl.vojteu.furniturefactory.orders.MaterialOrder;
import pl.vojteu.furniturefactory.orders.Order;
import pl.vojteu.furniturefactory.orders.RetailerOrder;
import pl.vojteu.furniturefactory.others.Resource;
import pl.vojteu.furniturefactory.products.Product;
import pl.vojteu.furniturefactory.products.Wardrobe;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        List<Employee> employees = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        List<Material> materialList = new ArrayList<>();
        List<Machine> machineList = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Map<String, Double> materialsMap = new HashMap<>();
        Map<String, String> materialSuppliers = new HashMap<>();
        Set<String> setOfSupplierMaterials = new HashSet<>();

        Factory factory = new Factory("Furniture factory");

        Company comp = new Company(new Address("Lubelska", "1", "Warszawa", "Masovian"),
                "decription", "Wojciech", "S");
        factory.setCompany(comp);
        final Orderer companyOrderer = new Orderer(1L, "Furniture factory", "sp. z. o. o", comp.getAddress());

        Employee employee1 = new Employee( "Wojciech", "S");
        employee1.setAddress(new Address("Lubelska", "1", "Warszawa", "Masovian"));

        Department department1 = new Department(1L, "IT");

        employees.add(employee1);
        department1.setEmployeeList(employees);
        departmentList.add(department1);

        factory.setEmployees(employees);
        factory.setDepartments(departmentList);

        Material material1 = new Glue(1L, "Glue", new BigDecimal(1), "L", "Wood glue");
        Material material2 = new Wood(2L, "Wood", new BigDecimal(1), "kg", "oak");

        materialList.add(material1);
        materialList.add(material2);

        factory.setMaterials(materialList);

        materialsMap.put(material1.getName(), 100.0);
        materialsMap.put(material2.getName(), 500.0);
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

        Product product3 = new WardrobeBuilder()
                .setId(3L)
                .setName("wardrobe small")
                .setPrice(50.0)
                .setManufacturingFactor(0.5)
                .setWardrobeKind("clothes wardrobe")
                .setDoors(doors)
                .build();

        LOGGER.info("\nprodcut1: " + product1);
        LOGGER.info("\nprodcut1: " + product2 + "\n");

        products.add(product1);
        products.add(product2);
        LOGGER.info(products);

        factory.whatProductIsThat(product1);

        Orderer orderer1 = new Orderer(2L, "Konrad", "Kon", new Address("Zlota",
                "1c", "Warszawa", "Masovian") );

        try{
//            factory.getProductPrice("Wood", products);
            factory.getProductPrice("swivel office chair", products);
        }
        catch(ProductNotFoundException e){
            LOGGER.error(e.getMessage());
        }

        LOGGER.info(orderer1);

        Supplier supplier = new Supplier(1L, "Jan", "Jakis", material2);
        materialSuppliers.put(supplier.getMaterial().getName(), supplier.getName() + " " + supplier.getSurname());
        factory.setMaterialSuppliers(materialSuppliers);
        setOfSupplierMaterials.add(supplier.getName() + " " + supplier.getSurname());

        LOGGER.info(factory.getMaterialSuppliers());

        Order order1 = new MaterialOrder(1L, companyOrderer, 120, "L", material1);
        Order order2 = new MaterialOrder(2L, companyOrderer, 1000, "kg", material2);

        LOGGER.info(order1);
        LOGGER.info(order2);

        List<Order> retailerOrders = new ArrayList<>();
        List<Order> materialOrders = new ArrayList<>();

        try{
            Order retailerOrder1 = new RetailerOrder(1L, orderer1, -1, "units", product1);
            Order retailerOrder2 = new RetailerOrder(2L, orderer1, 16, "units", product2);
            if (retailerOrder1.getQuantity() < 0 || retailerOrder2.getQuantity() < 0) {
                throw new InvalidQuantityException("Quantity cannot be negative.");
            }
            LOGGER.info(retailerOrder1);
            LOGGER.info(retailerOrder2);
            retailerOrders.add(retailerOrder1);
            retailerOrders.add(retailerOrder2);
        }
        catch(InvalidQuantityException e){
            LOGGER.error(e.getMessage());
        }

        double orderPrice = factory.countOrderCost(retailerOrders);
        LOGGER.info(orderPrice);
        if(orderPrice > factory.getDiscountBreakPoint()){
           orderPrice = factory.addDiscountOrder(retailerOrders, 0.2);
            LOGGER.info("Discount added. The price with discount is: " + orderPrice);
        }
        else{
            LOGGER.info("discount not added.");
        }

        LOGGER.info(product3);
        factory.addDiscount(product3, 0.3);

        LOGGER.info(factory.whoIsSupplier(material2));

        LOGGER.info(factory.isMaterialAvailable(material2, 200.0));

        material1.description();

        factory.massageMode(true,product1);
        factory.heatedSeat(true,product1);

        factory.setColor("Black", product1);

        try {
            factory.useMaterial(material1.getName(), 150.0, materialsMap);
        }
        catch(MaterialNotAvailableException e){
            LOGGER.error(e.getMessage());
        }

        LOGGER.info(materialsMap);
        try{
            factory.addMaterial(materialsMap, material1.getName(), 25000.0 );
        }
        catch(ProductionCapacityExceededException ex){
            LOGGER.error(ex.getMessage());
        }
        catch(NullPointerException e){
            LOGGER.error(e.getMessage());
        }

        LOGGER.info(materialsMap);

        try{
            LOGGER.info(factory.getMachineStatus("machine"));
            //LOGGER.info(factory.getMachineStatus("machine1"));
        }
        catch(MachineNotFoundException e){
            LOGGER.error(e.getMessage());
        }

        factory.readFile("src/main/resources/note.txt");

        for(Product product : products){
            LOGGER.info(product);
        }

        for (Map.Entry<String, Double> entry : materialsMap.entrySet()) {
            LOGGER.info("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        for(String string : setOfSupplierMaterials){
            LOGGER.info(string);
        }

        try(Resource resource = new Resource("src/main/resources/testResource.txt")) {
            resource.doWork();
        } catch (Exception e) {
            LOGGER.info("An exception occurred: " + e.getMessage());
        }

        factory.calculateUniqueWords("src/main/resources/txtexample.txt");

        Consumer<Product> wardrobePriceModifier = product -> {
            if (product instanceof Wardrobe) {
                Wardrobe wardrobe = (Wardrobe) product;
                wardrobe.setPrice(wardrobe.getPrice() * 0.9);
                LOGGER.info("New price for " + wardrobe.getName() + ": $" + wardrobe.getPrice());
            }
        };
        wardrobePriceModifier.accept(product2);
    }
}