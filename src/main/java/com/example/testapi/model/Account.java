package com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "account_num", nullable = false, unique = true)
    private Long accountNum;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(nullable = false)
    private Long balance;

    @JsonBackReference(value = "user-account")
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonManagedReference(value = "account-payment")
    @OneToMany(mappedBy = "destination_acc")
    private List<Payment> payments;

    @JsonManagedReference(value = "account-payment1")
    @OneToMany(mappedBy = "source_acc")
    private List<Payment> payments1;
}
