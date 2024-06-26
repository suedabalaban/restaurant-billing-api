package com.restaurant.billingsystem.model;

import java.util.List;

public class Order {
    private Long id;
    private Long customerId;
    private List<Long> menuItemIds;

    // Constructors
    public Order() {}

    public Order(Long id, Long customerId, List<Long> menuItemIds) {
        this.id = id;
        this.customerId = customerId;
        this.menuItemIds = menuItemIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getMenuItemIds() {
        return menuItemIds;
    }

    public void setMenuItemIds(List<Long> menuItemIds) {
        this.menuItemIds = menuItemIds;
    }
}
