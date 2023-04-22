package com.expenses.tracker.expensestracker.subscription.entity;

import com.expenses.tracker.expensestracker.transaction.entity.Transaction;
import jakarta.persistence.*;

@Entity
@Table(name = "subscription_expenses")
public class SubscriptionTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
}