package com.cognizant.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.inventoryservice.entity.Inventory;
import com.cognizant.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping
    public Inventory saveInventory(@RequestBody Inventory inventory) {
        return service.saveInventory(inventory);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return service.getAllInventory();
    }
}
