package com.restaurant.billingsystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private int orderId;
    private Date orderDate;
    private Double totalAmount;
    private Customer customer;
    private Table table;

    // Constructors
    public Order() {
        this.items = new ArrayList<>();
        this.orderDate = new Date();
        this.totalAmount = 0.0;
    }

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.orderDate = new Date();
        this.totalAmount = 0.0;
    }

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items); //Preserve original list by returning a copy
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(MenuItem item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        totalAmount += item.getPrice();
    }

    public void removeItem(MenuItem item) {
        if (this.items != null) {
            if (items.remove(item)) {
                totalAmount -= item.getPrice();
            }
        }
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
