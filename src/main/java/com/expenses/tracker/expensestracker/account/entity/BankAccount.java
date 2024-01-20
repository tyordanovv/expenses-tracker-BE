package com.expenses.tracker.expensestracker.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount extends Account{
    private String account_id;
    private String institution_id;
    private String institutionName;
    private String country;
}
