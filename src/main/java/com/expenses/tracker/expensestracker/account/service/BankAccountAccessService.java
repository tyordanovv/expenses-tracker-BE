package com.expenses.tracker.expensestracker.account.service;

import com.expenses.tracker.expensestracker.account.repository.AccountDao;
import com.expenses.tracker.expensestracker.account.entity.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class BankAccountAccessService implements AccountDao<BankAccount> {
    @Override
    public Optional<BankAccount> get(Long account_id) {
        return Optional.empty();
    }

    @Override
    public Set<BankAccount> getAll(Long user_id) {
        return null;
    }

    @Override
    public Long save(BankAccount account) {
        return 0L;
    }

    @Override
    public void update(BankAccount account) {

    }

    @Override
    public void delete(BankAccount account) {

    }
}
