package com.expenses.tracker.expensestracker.user.dto;

import java.util.Set;
import java.util.UUID;

public record UserDTO(
        Integer id,
        String firstName,
        String lastName,
        String email,
        Set<String> roles,
        Set<UUID> accounts
) {}
