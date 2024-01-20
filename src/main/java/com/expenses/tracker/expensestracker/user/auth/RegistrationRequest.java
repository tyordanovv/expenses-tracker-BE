package com.expenses.tracker.expensestracker.user.auth;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String country,
        String gender
) {
}
