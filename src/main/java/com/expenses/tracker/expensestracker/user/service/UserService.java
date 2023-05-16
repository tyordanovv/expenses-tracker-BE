package com.expenses.tracker.expensestracker.user.service;

import com.expenses.tracker.expensestracker.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean userExists(String email) {
        return true;
    }

    public void saveUser(User user) {
    }

    public String generateToken(Authentication authentication) {
        return "";
    }
}
