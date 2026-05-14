package com.nexus.wishlist_service.controllers;

import com.nexus.wishlist_service.dtos.request.WishlistRequest;
import com.nexus.wishlist_service.dtos.response.WishlistResponse;
import com.nexus.wishlist_service.services.WishlistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
public class WishlistController {

    @Autowired private WishlistService service;

    @PostMapping
    public ResponseEntity<WishlistResponse> add(@Valid @RequestBody WishlistRequest request) {
        return ResponseEntity.ok(service.agregar(request));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<WishlistResponse>> getByUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorUsuario(id));
    }
}