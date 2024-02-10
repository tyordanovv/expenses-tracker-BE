package com.expenses.tracker.expensestracker.account.service;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.account.entity.AccountDTO;
import com.expenses.tracker.expensestracker.account.mapper.AccountDTOMapper;
import com.expenses.tracker.expensestracker.account.repository.AccountDao;
import com.expenses.tracker.expensestracker.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class AccountDataAccessService implements AccountDao {
    private AccountRepository cashAccountRepository;
    private AccountDTOMapper mapper;

    @Override
    public Optional<Account> get(Long account_id) {
        return cashAccountRepository.findById(account_id);
    }

    @Override
    public Set<AccountDTO> getAll(Long userId) {
        return cashAccountRepository.findAllByUserId(userId)
                .stream()
                .map(account -> mapper.apply(account))
                .collect(Collectors.toSet());
    }

    @Override
    public Long save(Account account) {
        cashAccountRepository.save(account);
        return account.getId();
    }

    @Override
    public void update(Account account) {
        cashAccountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        cashAccountRepository.delete(account);
    }
}
