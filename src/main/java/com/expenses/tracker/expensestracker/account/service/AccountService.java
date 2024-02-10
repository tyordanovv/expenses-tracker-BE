package com.expenses.tracker.expensestracker.account.service;

import com.expenses.tracker.expensestracker.account.entity.AccountDTO;
import com.expenses.tracker.expensestracker.account.entity.CreateAccountRequest;

import java.util.Set;

public interface AccountService {
    AccountDTO createAccount(CreateAccountRequest userId);
    Set<AccountDTO> getAllUserAccounts(Long userId);
}
