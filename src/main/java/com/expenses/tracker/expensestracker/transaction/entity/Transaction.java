package com.expenses.tracker.expensestracker.transaction.entity;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
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
    private Long id;
    @Column(nullable = false,
            name = "amount")
    private double amount;
    @Column(nullable = false,
            name = "currency",
            length = 5)
    private String currency;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false,
            name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "transaction_category")
    @Enumerated(EnumType.STRING)
    private TransactionCategory transactionCategory;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name = "logo_url")
    private String logoURL;
    @Column(name = "note")
    private String note;

    public Transaction(
            double amount,
            String currency,
            LocalDate date,
            Account account,
            TransactionCategory category,
            String note
    ) {
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.account = account;
        this.transactionCategory = category;
        this.note = note;
    }
}