package com.expenses.tracker.expensestracker.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CASH_ACCOUNT")
public class CashAccount extends Account {
    private double amount;
}
