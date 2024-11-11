package pl.vojteu;

import java.util.Date;

public class CustomerOrder {
    private Long id;
    private Customer customer;
    private Date orderDate;
    private String status;
    private Double totalCost;

    public CustomerOrder(Customer customer, Date orderDate, String status, Double totalCost) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
