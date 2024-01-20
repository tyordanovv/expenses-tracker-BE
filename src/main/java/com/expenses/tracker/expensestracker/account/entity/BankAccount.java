package com.expenses.tracker.expensestracker.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount extends Account{
    @Column(name = "bank_account_id",
            nullable = false)
    private String account_id;
    @Column(name = "institution_id",
            nullable = false)
    private String institution_id;
    @Column(name = "institution_name",
            nullable = false)
    private String institutionName;
    @Column(name = "country",
            nullable = false)
    private String country;
}
