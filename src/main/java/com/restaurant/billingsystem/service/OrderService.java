package com.restaurant.billingsystem.service;

import com.restaurant.billingsystem.model.Order;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
public class OrderService {
    private Map<Integer, Order> orders;
    private int nextOrderId;

    public OrderService(){
        orders = new HashMap<>();
        nextOrderId = 1;
    }

    //Add order
    public Order addOrder(Order order){
        int orderId = nextOrderId++;
        order.setOrderId(orderId);
        orders.put(orderId, order);
        return order;
    }
    //Delete order
    public void deleteOrder(int orderId){
        if(orders.containsKey(orderId)){
            orders.remove(orderId);
        }else{
            System.out.println("Order ID not found.");
        }
    }
    //Update order
    public Order updateOrder(int orderId, Order updatedOrder){
        if(orders.containsKey(orderId)){
            orders.put(orderId, updatedOrder);
        }else{
            System.out.println("Order ID not found.");   
        }
        return null;
    }
    //Find order by their id
    public Order getOrderById(int orderId){
        return orders.get(orderId);
    }
    //List all orders
    public Map<Integer, Order> getAllOrders(){
        return orders;
    }
    //Calculate total price of the order by orderId
    public Double calculateTotalPrice(int orderId){
        Order order = orders.get(orderId);
        if(order != null){
            return order.getTotalAmount();
        }else{
            System.out.println("Order ID not found."); 
        } 
        return null;
    }
}
