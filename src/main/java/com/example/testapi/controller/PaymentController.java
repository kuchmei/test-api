package com.example.testapi.controller;

import com.example.testapi.model.Payment;
import com.example.testapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long addPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable("id") Long id) {
        paymentService.getPayment(id);
    }
}
