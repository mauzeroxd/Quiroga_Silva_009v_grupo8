package com.nexus.inventory_service.controllers;

import com.nexus.inventory_service.dtos.request.InventoryRequest;
import com.nexus.inventory_service.dtos.response.InventoryResponse;
import com.nexus.inventory_service.services.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventario")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/keys")
    public ResponseEntity<InventoryResponse> addKey(@Valid @RequestBody InventoryRequest request) {
        return new ResponseEntity<>(service.registrarKey(request), HttpStatus.CREATED);
    }
}