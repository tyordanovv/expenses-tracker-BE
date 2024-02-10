package com.expenses.tracker.expensestracker.account.mapper;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.account.entity.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AccountDTOMapper implements Function<Account, AccountDTO> {
    @Override
    public AccountDTO apply(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getName(),
                account.getAmount(),
                account.getAccountType()
        );
    }
}
