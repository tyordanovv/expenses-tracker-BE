package com.expenses.tracker.expensestracker.user.mapper;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Set;
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
                extractAccountIDs(user)
        );
    }

    private Set<Long> extractAccountIDs(User user) {
        if (user.getAccounts() == null){
            return null;
        } else
            return user.getAccounts()
                .stream()
                .map(Account::getId)
                .collect(Collectors.toSet());
    }

}
