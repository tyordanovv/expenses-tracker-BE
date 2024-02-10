package com.expenses.tracker.expensestracker.account.service;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.account.entity.AccountDTO;
import com.expenses.tracker.expensestracker.account.entity.AccountType;
import com.expenses.tracker.expensestracker.account.entity.CreateAccountRequest;
import com.expenses.tracker.expensestracker.user.entity.User;
import com.expenses.tracker.expensestracker.user.service.UserDataAccessService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class DefaultAccountServiceImpl implements AccountService {
    private final AccountDataAccessService accountAccessService;
    private final UserDataAccessService userAccessService;

    @Override
    public AccountDTO createAccount(CreateAccountRequest request) {
        Optional<User> user = userAccessService.selectUserById(request.userId());
        AccountType type = AccountType.CASH;

        if (user.isPresent()) {
            Account account = new Account(
                    user.get(),
                    request.accountName(),
                    request.amount(),
                    type
            );
            return new AccountDTO(
                    accountAccessService.save(account),
                    request.accountName(),
                    request.amount(),
                    type
            );
        } {
            throw new RuntimeException("User with id: " + request.userId() + " is not found!");
        }
    }

    @Override
    public Set<AccountDTO> getAllUserAccounts(Long userId) {
        return accountAccessService.getAll(userId);
    }
}
