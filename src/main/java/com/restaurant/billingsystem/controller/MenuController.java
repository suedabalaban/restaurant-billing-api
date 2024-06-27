package com.restaurant.billingsystem.controller;

import com.restaurant.billingsystem.model.MenuItem;
import com.restaurant.billingsystem.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuController{
    @Autowired
    private MenuService menuService; 
    
    @GetMapping
    public List<MenuItem> getAll() {
        return menuService.getAll();
    }

    @GetMapping("/name/{name}")
    public MenuItem getMenuItemByName(@PathVariable String name) {
        return menuService.getMenuItemByName(name);
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable int id) {
        return menuService.getMenuItemById(id);
    }
    
    @PostMapping
    public MenuItem addMenuItem(@RequestBody MenuItem item) {
        return menuService.addItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable int id){
        menuService.deleteItem(id);
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable int id, @RequestBody MenuItem updatedItem) {
        return menuService.updateItem(id, updatedItem);
    }
    
    
    
}
