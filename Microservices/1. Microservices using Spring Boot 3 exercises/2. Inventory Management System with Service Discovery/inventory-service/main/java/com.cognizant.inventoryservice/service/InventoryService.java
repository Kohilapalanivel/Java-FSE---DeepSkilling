package com.cognizant.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.inventoryservice.entity.Inventory;
import com.cognizant.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Inventory saveInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return repository.findAll();
    }
}
