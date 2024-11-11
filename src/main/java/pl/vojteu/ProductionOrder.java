package pl.vojteu;

import java.util.Date;

public class ProductionOrder {
    private Long id;
    private Product product;
    private Integer quantity;
    private String status;
    private Date startDate;
    private Date completionTime;

    public ProductionOrder(Product product, Integer quantity, String status, Date startDate, Date completionTime) {
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.startDate = startDate;
        this.completionTime = completionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }
}
