package com.expenses.tracker.expensestracker.user.dto;

import java.util.Set;
import java.util.UUID;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        Set<String> roles,
        Set<Long> accounts
) {}
