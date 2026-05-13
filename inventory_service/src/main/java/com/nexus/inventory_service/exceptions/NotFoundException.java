package com.nexus.inventory_service.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message); // Excepción para recursos inexistentes [cite: 18]
    }
}