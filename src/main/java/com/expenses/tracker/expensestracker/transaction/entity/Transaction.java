package com.expenses.tracker.expensestracker.transaction.entity;

import com.expenses.tracker.expensestracker.subscription.entity.SubscriptionTransaction;
import com.expenses.tracker.expensestracker.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_id_seq",
            sequenceName = "transaction_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_id_seq")
    @Column(name = "transaction_id")
    private Integer id;

    @OneToOne(mappedBy = "transaction")
    private SubscriptionTransaction subscriptionTransaction;

    @Column(nullable = false,
            name = "amount")
    private double amount;

    @Column(nullable = false,
            name = "currency",
            length = 5)
    private String currency;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

}