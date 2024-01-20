package com.expenses.tracker.expensestracker.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CASH_ACCOUNT")
public class CashAccount extends Account {
    @Column(name = "amount")
    private double amount;

}
