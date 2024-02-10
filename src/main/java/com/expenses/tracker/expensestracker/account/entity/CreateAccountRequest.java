package com.expenses.tracker.expensestracker.account.entity;

public record CreateAccountRequest (
        Long userId,
        String accountName,
        Double amount
){
}
