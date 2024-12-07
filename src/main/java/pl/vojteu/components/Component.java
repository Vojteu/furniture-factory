package pl.vojteu.components;

import pl.vojteu.materials.Material;

public abstract class Component {
    private Material material;

    public Component(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public abstract void description();

    @Override
    public String toString() {
        return "Component{" +
                "material=" + material +
                '}';
    }
}
