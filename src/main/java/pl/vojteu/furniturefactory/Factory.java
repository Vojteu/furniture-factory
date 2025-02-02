package pl.vojteu.furniturefactory;

import org.apache.log4j.*;
import pl.vojteu.furniturefactory.exceptions.checked.MachineNotFoundException;
import pl.vojteu.furniturefactory.exceptions.checked.MaterialNotAvailableException;
import pl.vojteu.furniturefactory.exceptions.checked.ProductNotFoundException;
import pl.vojteu.furniturefactory.exceptions.checked.ProductionCapacityExceededException;
import pl.vojteu.furniturefactory.entity.Company;
import pl.vojteu.furniturefactory.entity.Department;
import pl.vojteu.furniturefactory.entity.Employee;
import pl.vojteu.furniturefactory.entity.ResourceSupplier;
import pl.vojteu.furniturefactory.interfaces.*;
import pl.vojteu.furniturefactory.machines.Machine;
import pl.vojteu.furniturefactory.materials.Material;
import pl.vojteu.furniturefactory.orders.Order;
import pl.vojteu.furniturefactory.orders.RetailerOrder;
import pl.vojteu.furniturefactory.others.Connection;
import pl.vojteu.furniturefactory.others.ConnectionPool;
import pl.vojteu.furniturefactory.products.Chair;
import pl.vojteu.furniturefactory.products.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Factory implements ProductManager, OrderManager, MaterialManager, Customizable, Adjustable, Runnable {

    private final static Logger LOGGER = LogManager.getLogger(Factory.class);

    private int id;
    private String name;
    private LocalDateTime lastUpdated;
    private Company company;
    private List<Department> departments;
    private List<Employee> employees;
    private List<Order> orders;
    private List<ResourceSupplier> suppliers;
    private List<Material> materials;
    private List<Product> products;
    private List<Machine> machines;
    private Map<String, Double> materialsMap;
    private Map<String, String> materialSuppliers;

    private final double discountBreakPoint = 2000.0;
    ConnectionPool pool = new ConnectionPool(5);

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

    public Factory(ConnectionPool connectionPool, int id){
        this.id = id;
        this.pool = connectionPool;
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

    public List<ResourceSupplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<ResourceSupplier> suppliers) {
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
        try {
            ConsoleAppender consoleAppender = new ConsoleAppender();
            consoleAppender.setThreshold(Level.ALL);
            consoleAppender.setLayout(new PatternLayout("%d [%t] %-5p %c - %m%n"));
            consoleAppender.activateOptions();

            FileAppender fileAppender = new FileAppender();
            fileAppender.setFile("word_processor.log");
            fileAppender.setAppend(true);
            fileAppender.setThreshold(Level.ALL);
            fileAppender.setLayout(new PatternLayout("%d [%t] %-5p %c - %m%n"));
            fileAppender.activateOptions();

            LOGGER.addAppender(consoleAppender);
            LOGGER.addAppender(fileAppender);
            LOGGER.setLevel(Level.ALL);

        } catch (Exception e) {
            LOGGER.error("Failed to set up logger: " + e.getMessage());
        }
    }

    public static void getCurrentStock(Map<String, Double> materialsMap, LocalDateTime whenUpdated) {
        if (materialsMap == null || materialsMap.isEmpty()) {
            LOGGER.info("The materials map is empty or null.");
            return;
        }

        LOGGER.info("The current stock of materials is:");
        for (Map.Entry<String, Double> entry : materialsMap.entrySet()) {
            LOGGER.info(entry.getKey() + ": " + entry.getValue());
        }
        LOGGER.info("Updated at: " + whenUpdated);
    }

    public void useMaterial(String material, Double quantity, Map<String, Double> materialInventory)
            throws MaterialNotAvailableException {
        if (!materialInventory.containsKey(material) || materialInventory.get(material) < quantity) {
            throw new MaterialNotAvailableException("Material '" + material + "' is not available or insufficient.");
        }
        materialInventory.put(material, materialInventory.get(material) - quantity);
        LOGGER.info("Material '" + material + "' used: " + quantity + " units.");
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
            LOGGER.error(e.getMessage());
        } finally {
            br.close();
            fr.close();
        }
        return path;
    }

    @Override
    public void addDiscount(Product product, Double discount) {
        product.setPrice(product .getPrice() - product.getPrice()*discount);
        LOGGER.info("discount: " + discount*100 + "%" + " has been added to: " + product.getName());
    }

    @Override
    public void whatProductIsThat(Product product) {
        LOGGER.info(product.getName());
    }

    @Override
    public Double addDiscountOrder(List<Order> orders, double discount) {
        return countOrderCost(orders) - countOrderCost(orders) * discount;
    }

    @Override
    public Double countOrderCost(List<Order> orders) {
        double sum = 0.0;
        sum = orders.stream()
                .filter(order -> order instanceof RetailerOrder)
                .map(order -> (RetailerOrder) order)
                .mapToDouble(retailerOrder -> retailerOrder.getQuantity() * retailerOrder.getProduct().getPrice())
                .sum();
        return sum;
    }

    @Override
    public boolean isMaterialAvailable(Material material, double requiredQuantity) {
        return getMaterialsMap().get(material.getName()) >= requiredQuantity;
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
                LOGGER.info("Massage mode not activated.");
                return false;
            } else {
                chair.setMassageMode(true);
                LOGGER.info("Massage mode activated.");
                return true;
            }
        }
        else{
            LOGGER.info("it is not a Chair.");
            return false;
        }
    }

    @Override
    public boolean heatedSeat(boolean mode, Product product) {
        if(product instanceof Chair) {
            Chair chair = (Chair) product;
            if (!mode) {
                chair.setMassageMode(false);
                LOGGER.info("Heated seats not activated.");
                return false;
            } else {
                chair.setMassageMode(true);
                LOGGER.info("Heated seats activated.");
                return true;
            }
        }
        else{
            LOGGER.info("it is not a Chair.");
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

    public void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            LOGGER.error("there is an error: " + e.getMessage());
        }
    }

    public void calculateUniqueWords(String filePath){
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);

            Map<String, Long> wordCounts = lines.stream()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(word -> word.toLowerCase().replaceAll("^[^a-zA-Z]+|[^a-zA-Z]+$", ""))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            List<String> uniqueWords = wordCounts.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            LOGGER.info("Unique words");
            uniqueWords.forEach(System.out::println);
            LOGGER.info("\nunique words count: " + uniqueWords.size());
            Path inputFilePath = path;
            Path outputFilePath = inputFilePath.resolveSibling("unique_words.txt");
            Files.write(outputFilePath, uniqueWords);

            LOGGER.info("Unique words written to: " + outputFilePath);
        }
        catch(IOException e){
            LOGGER.info("Error reading this file " + filePath);
            LOGGER.error(e.getMessage());
        }
    }

    public Optional<Product> getMostExpensiveProduct(List<Product> products) {
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .map(Optional::of)
                .orElse(Optional.empty());
    }

    @Override
    public void run() {
        try {
            LOGGER.info("Factory is waiting for a connection...");

            Connection conn = pool.acquireConnection();
            LOGGER.info("connected " + conn.getName());

            Thread.sleep(2000);

            pool.releaseConnection(conn);
            LOGGER.info("Factory connection released " + conn.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}