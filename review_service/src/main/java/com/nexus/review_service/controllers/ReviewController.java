package com.nexus.review_service.controllers;

import com.nexus.review_service.dtos.request.ReviewRequest;
import com.nexus.review_service.dtos.response.ReviewResponse;
import com.nexus.review_service.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reseñas")
public class ReviewController {

    @Autowired private ReviewService service;

    @PostMapping
    public ResponseEntity<ReviewResponse> post(@Valid @RequestBody ReviewRequest request) {
        return new ResponseEntity<>(service.publicarReseña(request), HttpStatus.CREATED);
    }
}