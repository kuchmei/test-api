package com.example.testapi.repository;

import com.example.testapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> getPaymentById(Long id);
}
