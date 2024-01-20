package com.expenses.tracker.expensestracker.transaction.repository;

import com.expenses.tracker.expensestracker.transaction.entity.Transaction;
import com.expenses.tracker.expensestracker.transaction.entity.TransactionDetails;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TransactionDao {
    Optional<TransactionDetails> getTransactionDetails(Long transactionId);
    void updateTransactionDetails(TransactionDetails transactionDetails);
    Long saveTransactionDetails(TransactionDetails transactionDetails);
    Set<Transaction> getAllAccountTransactions(Long accountId);
    Long saveTransaction(Transaction transaction);
    List<Long> saveAllTransactions(List<Transaction> transactions);
    void updateTransaction(Transaction transaction);
    void deleteTransactionById(Long transactionId);
}
