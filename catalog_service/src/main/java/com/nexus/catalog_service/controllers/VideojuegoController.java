package com.nexus.catalog_service.controllers;

import com.nexus.catalog_service.dtos.response.VideojuegoResponse;
import com.nexus.catalog_service.services.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService service;

    @GetMapping
    public ResponseEntity<List<VideojuegoResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideojuegoResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}