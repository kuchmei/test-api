package com.example.testapi.service;

import com.example.testapi.model.Payment;

import java.util.List;

public interface PaymentService {

    Long createPayment(Payment payment);

    List<Payment> createPayments(Payment payment1, Payment payment2);

    Payment getPayment(Long id);
}
