package com.expenses.tracker.expensestracker.transaction.api.request;

import com.expenses.tracker.expensestracker.transaction.entity.TransactionCategory;

import java.time.LocalDate;

public record TransactionRequest(
        double amount,
        String currency,
        LocalDate date,
        Long accountId,
        TransactionCategory category,
        String note
) {
}
