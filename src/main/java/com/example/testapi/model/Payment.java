package com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JsonBackReference(value = "account-payment1")
    @ManyToOne()
    @JoinColumn(name = "source_acc_id")
    private Account source_acc;

    @JsonBackReference(value = "account-payment")
    @ManyToOne()
    @JoinColumn(name = "destination_acc_id")
    private Account destination_acc;

    private Long amount;

    private String reason;

    @Enumerated(EnumType.STRING)
    private Status status;
}
