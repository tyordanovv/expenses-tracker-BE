package com.expenses.tracker.expensestracker.account.repository;

import com.expenses.tracker.expensestracker.account.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
