package com.expenses.tracker.expensestracker.security.auth;

import com.expenses.tracker.expensestracker.user.entity.Gender;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
