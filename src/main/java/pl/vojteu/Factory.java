package pl.vojteu;

import pl.vojteu.interfaces.Adjustable;
import pl.vojteu.materials.Material;
import pl.vojteu.products.Product;

import java.util.Map;

public class Factory {

    public void getCurrentStock(Map<Material, Integer> materialsMap) {
        System.out.println("The current stock of materials is:");
        for(Material material : materialsMap.keySet() ){
            System.out.println(material.getName() + " " +
                    materialsMap.getOrDefault(material, 0) + " " + material.getUnit());
        }
    }

    void countProductCapacity(){
        Adjustable adjustable;
    }

    void countProductManufacturingTime(Product product, Long Quantity){

    }

}
