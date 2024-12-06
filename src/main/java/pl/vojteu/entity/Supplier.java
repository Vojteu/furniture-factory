package pl.vojteu.entity;

import pl.vojteu.materials.Material;

import java.util.List;

public class Supplier {

    private Long id;
    private String name;
    private String surname;
    private Address address;
    private List<Material> materials;

    public Supplier(Long id, String name, String surname, List<Material> materials) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.materials = materials;
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

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", materials=" + materials +
                '}';
    }
}
