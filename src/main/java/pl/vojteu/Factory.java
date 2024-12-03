package pl.vojteu;

import pl.vojteu.entity.*;
import pl.vojteu.exceptions.checked.MaterialAlreadyExistsException;
import pl.vojteu.exceptions.checked.MaterialNotAvailableException;
import pl.vojteu.materials.Material;
import pl.vojteu.products.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Factory {

    private String name;
    private List<Department> departments;
    private List<Employee> employees;
    private List<Order> orders;
    private List<Supplier> suppliers;
    private List<Material> materials;
    private List<Product> products;
    private Inventory inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    static {
        System.out.println("static block in Factory");
    }

    public final static void getCurrentStock(Map<Material, Integer> materialsMap) {
        System.out.println("The current stock of materials is:");
        for (Material material : materialsMap.keySet()) {
            System.out.println(material.getName() + " " +
                    materialsMap.getOrDefault(material, 0) + " " + material.getUnit());
        }
    }

    public void useMaterial(Material material, int quantity, Map<Material, Integer> materialInventory) throws MaterialNotAvailableException {
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
                throw new MaterialAlreadyExistsException("Material with name '" + newMaterial.getName() + "' already exists.");
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
}