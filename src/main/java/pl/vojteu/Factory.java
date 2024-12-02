package pl.vojteu;

import pl.vojteu.exceptions.MaterialAlreadyExistsException;
import pl.vojteu.exceptions.MaterialNotAvailableException;
import pl.vojteu.materials.Material;
import pl.vojteu.stock.Inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Factory {

    static {
        System.out.println("static block in Factory");
    }

    public final static void getCurrentStock(Map<Material, Integer> materialsMap) {
        System.out.println("The current stock of materials is:");
        for(Material material : materialsMap.keySet() ){
            System.out.println(material.getName() + " " +
                    materialsMap.getOrDefault(material, 0) + " " + material.getUnit());
        }
    }

    public void useMaterial(Material material, int quantity, Inventory materialInventory) throws MaterialNotAvailableException {
        if (!(materialInventory.getMaterials()).containsKey(material) || (materialInventory.getMaterials()).get(material) < quantity) {
            throw new MaterialNotAvailableException("Material '" + material + "' is not available or insufficient.");
        }
        (materialInventory.getMaterials()).put(material, materialInventory.getMaterials().get(material) - quantity);
        System.out.println("Material '" + material + "' used: " + quantity + " units.");
    }

    public void addMaterial(Map<Material, Integer> materialsList, Material newMaterial, Integer quantity){
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
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            br.close();
            fr.close();
        }
        return path;
    }
}