package com.restaurant.billingsystem.model;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int tableId;
    private int customerId;
    private Date reservationTime;

    //Constructors
    public Reservation(){

    }
    
    public Reservation(int reservationId, int tableId, int customerId,Date reservationTime){
        this.reservationId = reservationId;
        this.tableId = tableId;
        this.customerId = customerId;
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
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomer(int customerId) {
        this.customerId = customerId;
    }
    public Date getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }
}
