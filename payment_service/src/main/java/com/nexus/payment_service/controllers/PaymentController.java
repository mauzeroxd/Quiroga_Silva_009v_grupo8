package com.nexus.payment_service.controllers;

import com.nexus.payment_service.dtos.request.PaymentRequest;
import com.nexus.payment_service.dtos.response.PaymentResponse;
import com.nexus.payment_service.services.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pagos")
public class PaymentController {

    @Autowired private PaymentService service;

    @PostMapping
    public ResponseEntity<PaymentResponse> pay(@Valid @RequestBody PaymentRequest request) {
        return new ResponseEntity<>(service.procesarPago(request), HttpStatus.CREATED);
    }
}