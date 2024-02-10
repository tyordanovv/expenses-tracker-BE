package com.expenses.tracker.expensestracker.transaction.service;

import com.expenses.tracker.expensestracker.transaction.api.request.TransactionRequest;
import com.expenses.tracker.expensestracker.transaction.dto.TransactionDTO;

import java.util.Set;

public interface TransactionService {
    void deleteCashTransaction(Long accountId, Long transactionId);

    //TODO myb move cash methods to different interface
    Set<TransactionDTO> getAllTransactions(Long userId);

    Long createCashTransaction(Long userId, TransactionRequest request);
}
