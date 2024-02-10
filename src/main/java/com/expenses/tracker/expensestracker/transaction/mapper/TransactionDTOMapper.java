package com.expenses.tracker.expensestracker.transaction.mapper;

import com.expenses.tracker.expensestracker.transaction.dto.TransactionDTO;
import com.expenses.tracker.expensestracker.transaction.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionDTOMapper implements Function<Transaction, TransactionDTO> {
    @Override
    public TransactionDTO apply(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getDate(),
                transaction.getAccount().getId(),
                transaction.getTransactionCategory()
        );
    }
}
