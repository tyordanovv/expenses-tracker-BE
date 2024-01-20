package com.expenses.tracker.expensestracker.account.repository;

import java.util.Optional;
import java.util.Set;

public interface AccountDao<T> {
    Optional<T> get(Long account_id);
    Set<T> getAll(Long user_id);
    Long save(T account);
    void update(T account);
    void delete(T account);
}
