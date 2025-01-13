package pl.vojteu.furniturefactory.entity;

public class Company {

    private Address address;
    private String aboutUs;
    private String ownerName;
    private String ownerSurname;

    public Company(Address address, String aboutUs, String ownerName, String ownerSurname) {
        this.address = address;
        this.aboutUs = aboutUs;
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "address=" + address +
                ", aboutUs='" + aboutUs + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                '}';
    }
}
