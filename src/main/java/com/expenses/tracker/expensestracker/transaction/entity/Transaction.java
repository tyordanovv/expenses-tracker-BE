package com.expenses.tracker.expensestracker.transaction.entity;

import com.expenses.tracker.expensestracker.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_id_seq",
            sequenceName = "transaction_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_id_seq"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false,
            name = "amount")
    private double amount;

    @Column(nullable = false,
            name = "currency")
    private String currency;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "logo_url")
    private String logoURL;
}