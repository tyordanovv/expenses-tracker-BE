package com.expenses.tracker.expensestracker.user.mapper;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.account.entity.BankAccount;
import com.expenses.tracker.expensestracker.account.entity.CashAccount;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toSet()),
                extractCashAccountUUIDs(user),
                extractBankAccountUUIDs(user)
        );
    }

    private Set<UUID> extractCashAccountUUIDs(User user) {
        if (user.getCashAccounts() == null){
            return null;
        } else
            return user.getCashAccounts()
                .stream()
                .map(CashAccount::getUuid)
                .collect(Collectors.toSet());
    }

    private Set<UUID> extractBankAccountUUIDs(User user) {
        if (user.getBankAccounts() == null){
            return null;
        } else
            return user.getBankAccounts()
                    .stream()
                    .map(BankAccount::getUuid)
                    .collect(Collectors.toSet());
    }
}
