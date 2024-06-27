package com.restaurant.billingsystem.model;

import com.restaurant.billingsystem.model.Order;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private List<MenuItem> items;
    private int orderId;
    private Date orderDate;
    private Double totalAmount;

    //Constructors
    public Order(){

    }
    
    public Order(int orderId){
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.orderDate = new Date();
        this.totalAmount = 0.0;
    }

    //Getters and setters
    public int getOrderId(){
        return orderId;
    }
    public void setOrderId(int orderId){
         this.orderId = orderId;
    }

    public void addItem(MenuItem item){
        items.add(item);
        totalAmount += item.getPrice();
    }

    public void removeItem(MenuItem item){
        if(items.remove(item)){
            totalAmount -= item.getPrice();
        };
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public Date getOrderDate(){
        return orderDate;
    }

    public Double getTotalAmount(){
        return totalAmount;
    }
}