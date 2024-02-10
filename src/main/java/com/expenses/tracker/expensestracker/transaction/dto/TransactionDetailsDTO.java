package com.expenses.tracker.expensestracker.transaction.dto;

import com.expenses.tracker.expensestracker.transaction.entity.TransactionType;

public record TransactionDetailsDTO(
        Long transaction_id,
        TransactionType transactionType,
        String logoURL,
        String note,
        String location
) {
}
