package pl.vojteu;

import java.util.Date;

public class PurchaseOrder {
    private Long id;
    private Supplier supplier;
    private Date orderDate;
    private String status;
    private PurchaseOrderItem[] purchaseOrderItems;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Supplier supplier, Date orderDate, String status) {
        this.supplier = supplier;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PurchaseOrderItem[] getPurchaseOrderItems() {
        return purchaseOrderItems;
    }

    public void setPurchaseOrderItems(PurchaseOrderItem[] purchaseOrderItems) {
        this.purchaseOrderItems = purchaseOrderItems;
    }
}
