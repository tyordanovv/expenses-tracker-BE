package com.expenses.tracker.expensestracker.transaction.repository;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.transaction.api.request.TransactionRequest;
import com.expenses.tracker.expensestracker.transaction.entity.Transaction;

import java.util.List;
import java.util.Set;

public interface TransactionDao {
    Set<Transaction> getAllTransactions(Long userId);
    Long saveTransaction(Account account, TransactionRequest request);
    List<Long> saveAllTransactions(List<Transaction> transactions);
    void updateTransaction(Transaction transaction);
    void deleteTransactionById(Long transactionId);
}
