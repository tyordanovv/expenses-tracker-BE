package com.expenses.tracker.expensestracker.user.service;

import com.expenses.tracker.expensestracker.security.google.OAuth2UserInfo;
import com.expenses.tracker.expensestracker.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUserIfNotExist(OAuth2UserInfo userInfo) {
        return new User();
    }
}
