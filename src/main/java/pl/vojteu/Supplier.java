package pl.vojteu;

public class Supplier {
    private Long id;
    private String name;
    private String surname;
    Address address;
    Material Material;

    public Supplier(Long id, String name, String surname, Address address, pl.vojteu.Material material) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        Material = material;
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

    public pl.vojteu.Material getMaterial() {
        return Material;
    }

    public void setMaterial(pl.vojteu.Material material) {
        Material = material;
    }
}
