package com.nexus.order_service.controllers;

import com.nexus.order_service.dtos.request.OrderRequest;
import com.nexus.order_service.dtos.response.OrderResponse;
import com.nexus.order_service.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pedidos")
public class OrderController {

    @Autowired private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
        return new ResponseEntity<>(orderService.procesarPedido(request), HttpStatus.CREATED);
    }
}