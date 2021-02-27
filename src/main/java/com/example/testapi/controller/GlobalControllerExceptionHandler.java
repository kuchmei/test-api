package com.example.testapi.controller;

import com.example.testapi.exception.AccountNotFoundException;
import com.example.testapi.exception.PaymentNotFoundException;
import com.example.testapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({UserNotFoundException.class,
            AccountNotFoundException.class,
            PaymentNotFoundException.class})
    public void handleConflict() {
        // Nothing to do
    }
}