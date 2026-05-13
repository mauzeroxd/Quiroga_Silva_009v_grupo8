package com.nexus.shopping_cart_service.exceptions;

public class RemoteServiceException extends RuntimeException {
    public RemoteServiceException(String message) {
        super(message);
    }
}