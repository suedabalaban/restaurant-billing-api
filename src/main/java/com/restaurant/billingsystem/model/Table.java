package com.restaurant.billingsystem.model;

import java.util.List;
import java.util.ArrayList;

public class Table{
    private int tableId;
    private byte capacity;
    private String status; //"available", "reserved", "occupied", "needs_cleaning"
    private List<Order> orders;
    private List<Reservation> reservations;

    //Constructors
    public Table(){
        this.orders = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public Table(int tableId, byte capacity, String status){
        this.tableId = tableId;
        this.capacity = capacity;
        this.status = status;
        this.orders = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    //Getters and Setters
    public int getTableId(){
        return tableId;
    }
    public void setTableId(int id){
        this.tableId = id;
    }
    public byte getCapacity(){
        return capacity;
    }
    public void setCapacity(byte capacity){
        this.capacity = capacity;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    public void addOrder(Order order) {
        if (this.orders == null) {
            this.orders = new ArrayList<>();
        }
        this.orders.add(order);
        this.status = "occupied";
    }
    public void removeOrder(Order order) {
        if (this.orders != null) {
            orders.remove(order);
            if (orders.isEmpty()) {
                this.status = "available";
            }
        }
    }
    public void addReservation(Reservation reservation) {
        if (!this.status.equals("occupied")) {
            this.reservations.add(reservation);
            this.status = "reserved";
        } else {
            throw new IllegalStateException("Table is currently occupied and cannot be reserved.");
        }
    }
}