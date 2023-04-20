package com.expenses.tracker.expensestracker.transaction.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense extends Transaction{
    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    private String location;
}
