package com.expenses.tracker.expensestracker.user.service;

import com.expenses.tracker.expensestracker.user.dao.UserDao;
import com.expenses.tracker.expensestracker.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userDao.selectUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with email " + email +" was not found!"
                ));
    }
}
