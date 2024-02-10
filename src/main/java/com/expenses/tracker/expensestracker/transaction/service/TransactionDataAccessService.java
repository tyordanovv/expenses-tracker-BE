package com.expenses.tracker.expensestracker.transaction.service;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.account.entity.AccountType;
import com.expenses.tracker.expensestracker.transaction.api.request.TransactionRequest;
import com.expenses.tracker.expensestracker.transaction.entity.Transaction;
import com.expenses.tracker.expensestracker.transaction.entity.TransactionDetails;
import com.expenses.tracker.expensestracker.transaction.mapper.TransactionDTOMapper;
import com.expenses.tracker.expensestracker.transaction.repository.TransactionDao;
import com.expenses.tracker.expensestracker.transaction.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class TransactionDataAccessService implements TransactionDao {
    private TransactionRepository transactionRepository;

    @Override
    public Set<Transaction> getAllTransactions(Long userId) {
        return transactionRepository.findAllTransactionsByAccountId(userId);
    }

    @Override
    public Long saveTransaction(Account account, TransactionRequest request) {
        return transactionRepository.save(
                new Transaction(
                    request.amount(),
                    request.currency(),
                    request.date(),
                    account,
                    request.category(),
                    request.note()
                )).getId();
    }

    @Override
    public List<Long> saveAllTransactions(List<Transaction> transactions) {
        return transactionRepository.saveAll(transactions)
                .stream().map(Transaction::getId)
                .collect(Collectors.toList());
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        //TODO

    }

    @Override
    public void deleteTransactionById(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
