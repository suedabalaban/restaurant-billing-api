package com.restaurant.billingsystem.controller;

import com.restaurant.billingsystem.model.Customer;
import com.restaurant.billingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Map<Integer, Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
    Customer customer = customerService.findCustomerByEmail(email);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return customer;
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        customerService.updateCustomer(id, updatedCustomer);
        return updatedCustomer;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
