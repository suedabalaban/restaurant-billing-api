package com.restaurant.billingsystem.service;

import com.restaurant.billingsystem.model.Reservation;
import com.restaurant.billingsystem.model.Table;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    private List<Reservation> reservations;
    private int nextReservationId;

    public ReservationService(){
        this.reservations = new ArrayList<>();
        this.nextReservationId = 1;
    }

    //Add reservation
    public Reservation addReservation(Reservation reservation){
        reservation.setReservationId(nextReservationId++);
        reservations.add(reservation);
        return reservation;
    }

    //Update reservation
    public Reservation updateReservation(int reservationId, Reservation updatedReservation){
        for(int i = 0; i < reservations.size(); i++){
            if(reservations.get(i).getReservationId() == reservationId){
                reservations.set(i, updatedReservation);
                return updatedReservation;
            }
        }
        return null;
    }
    //Delete reservation
    public void deleteReservation(int reservationId){
        reservations.removeIf(reservation -> reservation.getReservationId() == reservationId);
    }
    //Get all reservations
    public List<Reservation> getAllReservations(){
        return reservations;
    }
    //Get reservation by id
    public Reservation getReservationById(int reservationId){
        for(Reservation reservation: reservations){
            if(reservation.getReservationId() == reservationId){
                return reservation;
            }
        }
        return null;
    }
    //Assign reservation to a table
    public void assignReservationToTable(int reservationId, Table table){
        Reservation reservation = getReservationById(reservationId);
        if(reservation != null){
            reservation.setTableId(table.getTableId());
            table.addReservation(reservation);
        }
    }


}
