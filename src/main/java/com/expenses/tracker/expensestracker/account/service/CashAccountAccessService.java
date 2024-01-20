package com.expenses.tracker.expensestracker.account.service;

import com.expenses.tracker.expensestracker.account.repository.AccountDao;
import com.expenses.tracker.expensestracker.account.entity.CashAccount;
import com.expenses.tracker.expensestracker.account.repository.CashAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
@AllArgsConstructor
public class CashAccountAccessService implements AccountDao<CashAccount> {
    private CashAccountRepository cashAccountRepository;

    @Override
    public Optional<CashAccount> get(Long account_id) {
        return cashAccountRepository.findById(account_id);
    }

    @Override
    public Set<CashAccount> getAll(Long user_id) {
        return cashAccountRepository.findAllByUserId(user_id);
    }

    @Override
    public Long save(CashAccount account) {
        cashAccountRepository.save(account);
        return account.getId();
    }

    @Override
    public void update(CashAccount account) {
        cashAccountRepository.save(account);
    }

    @Override
    public void delete(CashAccount account) {
        cashAccountRepository.delete(account);
    }
}
