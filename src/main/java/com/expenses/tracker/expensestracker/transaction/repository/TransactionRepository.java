package com.expenses.tracker.expensestracker.transaction.repository;

import com.expenses.tracker.expensestracker.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    Set<Transaction> findAllTransactionsByAccountId(Long accountId);
}
