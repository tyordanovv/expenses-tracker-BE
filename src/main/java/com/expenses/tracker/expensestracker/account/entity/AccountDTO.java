package com.expenses.tracker.expensestracker.account.entity;

public record AccountDTO(
        Long accountId,
        String AccountName,
        Double amount,
        AccountType accountType
) {
}
