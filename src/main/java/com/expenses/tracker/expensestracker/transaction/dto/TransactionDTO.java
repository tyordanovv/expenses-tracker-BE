package com.expenses.tracker.expensestracker.transaction.dto;

import com.expenses.tracker.expensestracker.transaction.entity.TransactionCategory;

import java.time.LocalDate;

public record TransactionDTO(
        Long id,
        double amount,
        String currency,
        LocalDate date,
        Long accountId,
        TransactionCategory category
) {
}
