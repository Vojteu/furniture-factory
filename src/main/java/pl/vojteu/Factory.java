package pl.vojteu;

import pl.vojteu.entity.*;
import pl.vojteu.exceptions.checked.MachineNotFoundException;
import pl.vojteu.exceptions.checked.MaterialNotAvailableException;
import pl.vojteu.exceptions.checked.ProductNotFoundException;
import pl.vojteu.exceptions.checked.ProductionCapacityExceededException;
import pl.vojteu.interfaces.*;
import pl.vojteu.machines.Machine;
import pl.vojteu.materials.Material;
import pl.vojteu.orders.Order;
import pl.vojteu.orders.RetailerOrder;
import pl.vojteu.products.Chair;
import pl.vojteu.products.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Factory implements ProductManager, OrderManager, MaterialManager, Customizable, Adjustable {

    private String name;
    private LocalDateTime lastUpdated;
    private Company company;
    private List<Department> departments;
    private List<Employee> employees;
    private List<Order> orders;
    private List<Supplier> suppliers;
    private List<Material> materials;
    private List<Product> products;
    private List<Machine> machines;
    private Map<String, Double> materialsMap;
    private Map<String, String> materialSuppliers;

    private final double discountBreakPoint = 2000.0;

    public Factory(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.products = new ArrayList<>();
        this.machines = new ArrayList<>();
        this.materialsMap = new HashMap<>();
        this.materialSuppliers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Map<String, Double> getMaterialsMap() {
        return materialsMap;
    }

    public void setMaterialsMap(Map<String, Double> materialsMap) {
        this.materialsMap = materialsMap;
    }

    public double getDiscountBreakPoint() {
        return discountBreakPoint;
    }

    public Map<String, String> getMaterialSuppliers() {
        return materialSuppliers;
    }

    public void setMaterialSuppliers(Map<String, String> materialSuppliers) {
        this.materialSuppliers = materialSuppliers;
    }

    static {
        System.out.println("static block in Factory");
    }

    public static void getCurrentStock(Map<String, Double> materialsMap, LocalDateTime whenUpdated) {
        if (materialsMap == null || materialsMap.isEmpty()) {
            System.out.println("The materials map is empty or null.");
            return;
        }

        System.out.println("The current stock of materials is:");
        for (Map.Entry<String, Double> entry : materialsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Updated at: " + whenUpdated);
    }

    public void useMaterial(String material, Double quantity, Map<String, Double> materialInventory)
            throws MaterialNotAvailableException {
        if (!materialInventory.containsKey(material) || materialInventory.get(material) < quantity) {
            throw new MaterialNotAvailableException("Material '" + material + "' is not available or insufficient.");
        }
        materialInventory.put(material, materialInventory.get(material) - quantity);
        System.out.println("Material '" + material + "' used: " + quantity + " units.");
    }

    public void addMaterial(Map<String, Double> materialsMap, String newMaterial, Double quantity)
            throws ProductionCapacityExceededException {
            Double newQuantity = materialsMap.get(newMaterial) + quantity;
            if(newQuantity > 25000.0)
                throw new ProductionCapacityExceededException("Production capacity exceeded.");
            materialsMap.put(newMaterial, newQuantity);
    }

    public static String readNoteFile(String path) throws IOException, FileNotFoundException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        try {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            br.close();
            fr.close();
        }
        return path;
    }

    @Override
    public void addDiscount(Product product, Double discount) {
        product.setPrice(product .getPrice() - product.getPrice()*discount);
        System.out.println("discount: " + discount*100 + "%" + " has been added to: " + product.getName());
    }

    @Override
    public void whatProductIsThat(Product product) {
        System.out.println(product.getName());
    }

    @Override
    public Double addDiscountOrder(List<Order> orders, double discount) {
        return countOrderCost(orders) - countOrderCost(orders) * discount;
    }

    @Override
    public Double countOrderCost(List<Order> orders) {
        double sum = 0.0;
        for(Order order : orders) {
            if(order.getClass() == RetailerOrder.class) {
                RetailerOrder retailerOrder = (RetailerOrder) order;
                sum += retailerOrder.getQuantity() * retailerOrder.getProduct().getPrice();
            }
        }
        return sum;
    }

    @Override
    public boolean isMaterialAvailable(Material material, double requiredQuantity) {
        if(getMaterialsMap().get(material.getName()) >= requiredQuantity)
            return true;
        else
            return false;
    }

    @Override
    public String whoIsSupplier(Material material) {
       return getMaterialSuppliers().get(material.getName());
    }

    @Override
    public boolean massageMode(boolean mode, Product product) {
        if(product instanceof Chair) {
            Chair chair = (Chair) product;
            if (!mode) {
                chair.setMassageMode(false);
                System.out.println("Massage mode not activated.");
                return false;
            } else {
                chair.setMassageMode(true);
                System.out.println("Massage mode activated.");
                return true;
            }
        }
        else{
            System.out.println("it is not a Chair.");
            return false;
        }
    }

    @Override
    public boolean heatedSeat(boolean mode, Product product) {
        if(product instanceof Chair) {
            Chair chair = (Chair) product;
            if (!mode) {
                chair.setMassageMode(false);
                System.out.println("Heated seats not activated.");
                return false;
            } else {
                chair.setMassageMode(true);
                System.out.println("Heated seats activated.");
                return true;
            }
        }
        else{
            System.out.println("it is not a Chair.");
            return false;
        }
    }

    @Override
    public void setColor(String color, Product product) {
        product.setColor(color);
    }

    public double getProductPrice(String name, List<Product> products) throws ProductNotFoundException {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .map(Product::getPrice)
                .orElseThrow(() -> new ProductNotFoundException("Product with name " + name + " not found"));
    }

    public String getMachineStatus(String name) throws MachineNotFoundException {
        return machines.stream()
                .filter(machine -> machine.getName().equals(name))
                .findFirst()
                .map(Machine::getStatus)
                .orElseThrow(() -> new MachineNotFoundException("Machine with name " + name + " not found"));
    }
}