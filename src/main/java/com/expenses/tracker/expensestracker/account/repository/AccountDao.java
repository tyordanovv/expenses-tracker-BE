package com.expenses.tracker.expensestracker.account.repository;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.account.entity.AccountDTO;

import java.util.Optional;
import java.util.Set;

public interface AccountDao {
    Optional<Account> get(Long account_id);
    Set<AccountDTO> getAll(Long user_id);
    Long save(Account account);
    void update(Account account);
    void delete(Account account);
}
