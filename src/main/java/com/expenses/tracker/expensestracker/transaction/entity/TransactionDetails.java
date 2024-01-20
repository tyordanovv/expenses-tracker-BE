package com.expenses.tracker.expensestracker.transaction.entity;

import com.expenses.tracker.expensestracker.user.entity.User;
import jakarta.persistence.*;

@Entity
@Table
public class TransactionDetails {
    @Id
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Transaction transaction;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name = "logo_url")
    private String logoURL;
    @Column(name = "note")
    private String note;
    @Column(name = "location")
    private String location;
}
