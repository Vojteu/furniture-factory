package pl.vojteu;

import pl.vojteu.entity.*;
import pl.vojteu.exceptions.checked.MaterialAlreadyExistsException;
import pl.vojteu.exceptions.checked.MaterialNotAvailableException;
import pl.vojteu.interfaces.ProductManager;
import pl.vojteu.machines.Machine;
import pl.vojteu.materials.Material;
import pl.vojteu.orders.Order;
import pl.vojteu.products.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory implements ProductManager {

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
    private Map<String, Integer> materialsMap;

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

    public Map<String, Integer> getMaterialsMap() {
        return materialsMap;
    }

    public void setMaterialsMap(Map<String, Integer> materialsMap) {
        this.materialsMap = materialsMap;
    }

    static {
        System.out.println("static block in Factory");
    }

    public final static void getCurrentStock(Map<String, Integer> materialsMap, LocalDateTime whenUpdated) {
        if (materialsMap == null || materialsMap.isEmpty()) {
            System.out.println("The materials map is empty or null.");
            return;
        }

        System.out.println("The current stock of materials is:");
        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Updated at: " + whenUpdated);
    }

    public void useMaterial(Material material, int quantity, Map<Material, Integer> materialInventory)
            throws MaterialNotAvailableException {
        if (!materialInventory.containsKey(material) || materialInventory.get(material) < quantity) {
            throw new MaterialNotAvailableException("Material '" + material + "' is not available or insufficient.");
        }
        materialInventory.put(material, materialInventory.get(material) - quantity);
        System.out.println("Material '" + material + "' used: " + quantity + " units.");
    }

    public void addMaterial(Map<Material, Integer> materialsList, Material newMaterial, Integer quantity) {
        try {
            boolean exists = materialsList.keySet().stream()
                    .anyMatch(material -> material.getName().equals(newMaterial.getName()));
            if (exists) {
                throw new MaterialAlreadyExistsException("Material with name '" + newMaterial.getName()
                        + "' already exists.");
            }

            materialsList.put(newMaterial, quantity);
            System.out.println("Material added successfully: " + newMaterial.getName());
        } catch (MaterialAlreadyExistsException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
    public void addDiscount() { 
        System.out.println("discount added");
    }

    @Override
    public void whatProductIsThat(Product product) {
        System.out.println(product.getName());
    }
}