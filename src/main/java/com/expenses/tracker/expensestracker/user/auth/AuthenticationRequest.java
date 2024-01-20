package com.expenses.tracker.expensestracker.user.auth;

public record AuthenticationRequest (
        String email,
        String password
) {
}