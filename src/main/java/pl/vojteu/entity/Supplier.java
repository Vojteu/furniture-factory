package pl.vojteu.entity;

import pl.vojteu.materials.Material;

public class Supplier {

    private Long id;
    private String name;
    private String surname;
    private Address address;
    private Material material;

    public Supplier(Long id, String name, String surname, Address address, Material material) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", material=" + material +
                '}';
    }
}
