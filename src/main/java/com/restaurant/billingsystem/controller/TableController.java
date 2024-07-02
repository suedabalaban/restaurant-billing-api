package com.restaurant.billingsystem.controller;

import com.restaurant.billingsystem.model.Table;
import com.restaurant.billingsystem.service.TableService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
@RequestMapping("/tables")
public class TableController {
    @Autowired
    private TableService tableService;

    @PostMapping
    public Table addTable(@RequestBody Table table) {
        return tableService.addTable(table);
    }

    @PutMapping("/{id}")
    public Table updateTable(@PathVariable int id, @RequestBody Table updatedTable) {
        return tableService.updateTable(id, updatedTable);
    }

    @GetMapping("/{id}")
    public Table getTableById(@PathVariable int id) {
        return tableService.getTableById(id);
    }

    @GetMapping
    public Map<Integer, Table> getAllTables() {
        return tableService.getAllTables();
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable int id) {
        tableService.deleteTable(id);
    }

    @PostMapping("/{tableId}/addReservation/{id}")
    public void addReservationToTable(@PathVariable int tableId, @PathVariable int reservationId) {
        tableService.addReservationToTable(tableId, reservationId);
    }
}
