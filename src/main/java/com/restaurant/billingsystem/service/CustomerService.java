package com.restaurant.billingsystem.service;

import com.restaurant.billingsystem.model.Customer;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
public class CustomerService {
    private Map<Integer, Customer> customers;
    private int nextCustomerId;
    
    public CustomerService(){
        customers = new HashMap<>();
        nextCustomerId = 1;
    }
    //Add customer
    public int createCustomer(Customer customer) {
        int customerId = nextCustomerId++;
        customer.setId(customerId);    
        customers.put(customerId, customer);
        return customerId;
    }
    //List all customers
    public Map<Integer, Customer> getAllCustomers() {
        return customers;
    }
    //Find customer by their id
    public Customer getCustomerById(int id) {
        return customers.get(id);
    }
    //Update customer by giving their id
    public Customer updateCustomer(int id, Customer updatedCustomer) {
        if(customers.containsKey(id)){
            customers.put(id, updatedCustomer);
            return updatedCustomer;
        }else{
            System.out.println("Customer ID not found.");
            return null;
        }
    }
    //Delete customer by id
    public void deleteCustomer(int id) {
        if(customers.containsKey(id)){
            customers.remove(id);
        }else{
            System.out.println("Customer ID not found.");
        }
    }
    //Find user by their email
    public Customer findUserByEmail(String email){
        for(Customer customer: customers.values()){
            if(customer.getEmail().equalsIgnoreCase(email)){
                return customer;
            }
        }
        return null;
    }
}
