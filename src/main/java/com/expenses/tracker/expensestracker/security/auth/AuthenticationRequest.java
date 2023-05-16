package com.expenses.tracker.expensestracker.security.auth;

public record AuthenticationRequest (
        String email,
        String password
) {
}