package com.expenses.tracker.expensestracker.account.repository;

import com.expenses.tracker.expensestracker.account.entity.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface CashAccountRepository extends JpaRepository<CashAccount, Long> {
    Set<CashAccount> findAllByUserId(Long userId);
}
