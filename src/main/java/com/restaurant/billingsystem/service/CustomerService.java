package com.restaurant.billingsystem.service;

import com.restaurant.billingsystem.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = getCustomerById(id);
        if (existingCustomer != null) {
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
        }
        return existingCustomer;
    }

    public void deleteCustomer(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }
}
