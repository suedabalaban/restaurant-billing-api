package com.restaurant.billingsystem.service;

import com.restaurant.billingsystem.model.Table;
import com.restaurant.billingsystem.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TableService {
    private Map<Integer, Table> tables;
    private int nextTableId;

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
            tables.put(id, updatedTable);
            return updatedTable;
        } else {
            System.out.println("Table ID not found.");
            return null;
        }
    }

    public Table getTableById(int id) {
        return tables.get(id);
    }

    public Map<Integer, Table> getAllTables() {
        return tables;
    }

    public void deleteTable(int id) {
        tables.remove(id);
    }

    public void addReservationToTable(int tableId, Reservation reservation) {
        Table table = getTableById(tableId);
        if (table != null) {
            table.addReservation(reservation);
        }
    }
}
