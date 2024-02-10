package com.expenses.tracker.expensestracker.transaction.service;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.account.entity.AccountType;
import com.expenses.tracker.expensestracker.account.service.AccountDataAccessService;
import com.expenses.tracker.expensestracker.transaction.api.request.TransactionRequest;
import com.expenses.tracker.expensestracker.transaction.dto.TransactionDTO;
import com.expenses.tracker.expensestracker.transaction.mapper.TransactionDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionDataAccessService transactionDataAccessService;
    private final AccountDataAccessService accountDataAccessService;
    private TransactionDTOMapper transactionDTOMapper;

    @Override
    public void deleteCashTransaction(Long accountId, Long transactionId) {
        Optional<Account> account = accountDataAccessService.get(accountId);
        if (account.isEmpty()){
            throw new RuntimeException("Account with id = " + accountId + " is not found!");
        } else {
            if (!account.get().getAccountType().equals(AccountType.CASH)) {
                throw new RuntimeException("Account with id = " + accountId+ " does not have the correct account type (CASH)");
            } else {
                transactionDataAccessService.deleteTransactionById(transactionId);
            }
        }
    }

    @Override
    public Set<TransactionDTO> getAllTransactions(Long userId) {
        return transactionDataAccessService.getAllTransactions(userId)
                .stream()
                .map(transaction -> transactionDTOMapper.apply(transaction))
                .collect(Collectors.toSet());
    }

    @Override
    public Long createCashTransaction(Long userId, TransactionRequest request) {
        Optional<Account> account = accountDataAccessService.get(request.accountId());
        if (account.isEmpty()){
            throw new RuntimeException("Account with id = " + request.accountId() + " is not found!");
        } else {
            if (!account.get().getAccountType().equals(AccountType.CASH)) {
                throw new RuntimeException("Account with id = " + request.accountId() + " does not have the correct account type (CASH)");
            } else {
                if (account.get().getUser().getId().equals(userId)){
                    return transactionDataAccessService.saveTransaction(account.get(), request);
                }
                throw new RuntimeException("" +
                        "Account with id = " + request.accountId() + " does not belongs to to right user!" +
                        "User with id = " + userId + " try to save transaction in account, which belongs to user with " +
                        "id = " + account.get().getUser().getId()
                );
            }
        }
    }
}
