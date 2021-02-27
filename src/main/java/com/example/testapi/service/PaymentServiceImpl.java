package com.example.testapi.service;

import com.example.testapi.exception.PaymentNotFoundException;
import com.example.testapi.model.Payment;
import com.example.testapi.model.Status;
import com.example.testapi.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Long createPayment(Payment payment) {
        if (payment.getSource_acc().getBalance() < payment.getAmount()) {
            System.out.println("Money not enough!!!");
            payment.setStatus(Status.FAILURE);
            return 0L;
        } else {
            Payment createdPayment = paymentRepository.save(payment);
            payment.getDestination_acc().setBalance(payment.getDestination_acc().getBalance() + payment.getAmount());
            payment.getSource_acc().setBalance(payment.getSource_acc().getBalance() - payment.getAmount());
            payment.setStatus(Status.SUCCESS);
            return createdPayment.getId();
        }
    }

    @Override
    public List<Payment> createPayments(Payment payment1, Payment payment2) {
        if (payment1.getSource_acc().getBalance() < payment1.getAmount() || payment2.getSource_acc().getBalance() < payment2.getAmount()) {
            System.out.println("Money not enough!!!!");
            payment1.setStatus(Status.FAILURE);
            payment2.setStatus(Status.FAILURE);
            return new ArrayList<>();
        } else {
            Payment createdPayment1 = paymentRepository.save(payment1);
            payment1.getDestination_acc().setBalance(payment1.getDestination_acc().getBalance() + payment1.getAmount());
            payment1.getSource_acc().setBalance(payment1.getSource_acc().getBalance() - payment1.getAmount());
            payment1.setStatus(Status.SUCCESS);

            Payment createdPayment2 = paymentRepository.save(payment2);
            payment2.getDestination_acc().setBalance(payment2.getDestination_acc().getBalance() + payment2.getAmount());
            payment2.getSource_acc().setBalance(payment2.getSource_acc().getBalance() - payment2.getAmount());
            payment2.setStatus(Status.SUCCESS);

            List<Payment> payments = new ArrayList<>();
            payments.add(createdPayment2);
            payments.add(createdPayment1);

            return payments;
        }
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentRepository.getPaymentById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found"));
    }
}
