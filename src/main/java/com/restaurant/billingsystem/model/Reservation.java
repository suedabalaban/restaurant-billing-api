package com.restaurant.billingsystem.model;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int tableId;
    private Customer customer;
    private Date reservationTime;

    //Constructors
    public Reservation(){

    }
    
    public Reservation(int reservationId, int tableId, Customer customer,Date reservationTime){
        this.reservationId = reservationId;
        this.tableId = tableId;
        this.customer = customer;
        this.reservationTime = reservationTime;
    }
    
     // Getters and Setters
     public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public int getTableId() {
        return tableId;
    }
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Date getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }
}
