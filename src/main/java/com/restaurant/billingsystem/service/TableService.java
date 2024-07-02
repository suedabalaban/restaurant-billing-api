package com.restaurant.billingsystem.service;

import com.restaurant.billingsystem.model.Table;
import com.restaurant.billingsystem.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TableService {
    private Map<Integer, Table> tables;
    private int nextTableId;

    @Autowired
    private ReservationService reservationService;


    public TableService() {
        tables = new HashMap<>();
        nextTableId = 1;
    }

    public Table addTable(Table table) {
        int tableId = nextTableId++;
        table.setTableId(tableId);
        tables.put(tableId, table);
        return table;
    }

    public Table updateTable(int id, Table updatedTable) {
        if (tables.containsKey(id)) {
            updatedTable.setTableId(id);
            tables.put(id, updatedTable);
            return updatedTable;
        } else {
            throw new IllegalArgumentException("Table ID not found.");
        }
    }

    public Table getTableById(int id) {
        return tables.get(id);
    }

    public Map<Integer, Table> getAllTables() {
        return tables;
    }

    public void deleteTable(int id) {
        if(tables.containsKey(id)){
            tables.remove(id);
        }else{
            throw new IllegalArgumentException("Table ID not found.");
        }
    }

    public void addReservationToTable(int tableId, int reservationId){
        Table table = getTableById(tableId);
        Reservation reservation = reservationService.getReservationById(reservationId);
        if(table != null && "available".equalsIgnoreCase(table.getStatus())){
            table.addReservation(reservation);
            table.setStatus("reserved");
        }
    }
}
