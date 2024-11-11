package pl.vojteu;

public class PurchaseOrderItem {
    private Long id;
    private PurchaseOrder order;
    private Material material;
    private Integer quantity;
    private Double unitCost;

    public PurchaseOrderItem(PurchaseOrder order, Material material, Integer quantity, Double unitCost) {
        this.order = order;
        this.material = material;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }
}
