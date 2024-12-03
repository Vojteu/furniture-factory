package pl.vojteu.entity;


public class Order {

    private Long id;
    private Orderer orderer;
    private Long units;

    public Order(Long id, Orderer orderer, Long units) {
        this.id = id;
        this.orderer = orderer;
        this.units = units;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orderer getOrderer() {
        return orderer;
    }

    public void setOrderer(Orderer orderer) {
        this.orderer = orderer;
    }

    public Long getUnits() {
        return units;
    }

    public void setUnits(Long units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderer=" + orderer +
                ", units=" + units +
                '}';
    }
}
