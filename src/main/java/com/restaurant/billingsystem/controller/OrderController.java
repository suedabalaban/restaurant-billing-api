package com.restaurant.billingsystem.controller;

import com.restaurant.billingsystem.model.Order;
import com.restaurant.billingsystem.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
       orderService.addOrder(order);
       return order;
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public Map<Integer,Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }

    @GetMapping("/price/{id}")
    public Double calculateTotalPrice(@PathVariable int id) {
        return orderService.calculateTotalPrice(id);
    }
}
