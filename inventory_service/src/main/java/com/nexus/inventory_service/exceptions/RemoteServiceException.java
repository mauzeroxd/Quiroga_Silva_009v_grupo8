package com.nexus.inventory_service.exceptions;

public class RemoteServiceException extends RuntimeException {
    public RemoteServiceException(String message) {
        super(message); // Excepción para errores en otros microservicios [cite: 19]
    }
}