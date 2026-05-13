package com.nexus.shopping_cart_service.controllers;

import com.nexus.shopping_cart_service.dtos.request.CartRequest;
import com.nexus.shopping_cart_service.dtos.response.CartResponse;
import com.nexus.shopping_cart_service.services.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carrito")
public class CartController {
    @Autowired private CartService service;

    @PostMapping
    public ResponseEntity<CartResponse> add(@Valid @RequestBody CartRequest request) {
        return ResponseEntity.ok(service.agregarAlCarrito(request));
    }
}