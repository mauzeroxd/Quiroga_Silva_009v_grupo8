package com.nexus.review_service.exceptions;

import com.nexus.review_service.dtos.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value())
                .error("Not Found").message(ex.getMessage()).path(request.getRequestURI()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RemoteServiceException.class)
    public ResponseEntity<ErrorResponse> handleRemote(RemoteServiceException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now()).status(HttpStatus.BAD_GATEWAY.value())
                .error("Remote Service Error").message(ex.getMessage()).path(request.getRequestURI()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
    }
}