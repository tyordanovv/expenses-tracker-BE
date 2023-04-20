package com.expenses.tracker.expensestracker.transaction.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "incomes")
public class Income extends Transaction{
    @Enumerated(EnumType.STRING)
    private IncomeCategory category;
}
