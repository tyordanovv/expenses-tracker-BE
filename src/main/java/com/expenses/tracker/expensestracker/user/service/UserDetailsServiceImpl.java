package com.expenses.tracker.expensestracker.user.service;

import com.expenses.tracker.expensestracker.user.repository.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userDao.selectUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with email " + email +" was not found!"
                ));
    }
}
