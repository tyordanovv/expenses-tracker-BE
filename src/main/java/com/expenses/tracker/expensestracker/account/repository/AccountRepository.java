package com.expenses.tracker.expensestracker.account.repository;

import com.expenses.tracker.expensestracker.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
    Set<Account> findAllByUserId(Long userId);
}
