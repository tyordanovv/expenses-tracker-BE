package com.expenses.tracker.expensestracker.user.service;

import com.expenses.tracker.expensestracker.user.dao.UserDao;
import com.expenses.tracker.expensestracker.user.dto.UserDTOSummary;
import com.expenses.tracker.expensestracker.user.entity.User;
import com.expenses.tracker.expensestracker.user.entity.UserDetails;
import com.expenses.tracker.expensestracker.user.repository.UserDetailsRepository;
import com.expenses.tracker.expensestracker.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserDataAccessService implements UserDao {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Override
    public List<User> selectAllUsers() {
        Page<User> page = userRepository.findAll(Pageable.ofSize(1000));
        return page.getContent();
    }

    @Override
    public Optional<User> selectUserById(Integer customerId) {
        return userRepository.findById(customerId);
    }

    @Override
    public Optional<User> selectUserByEmail(String email) {
        return userRepository.findCustomerByEmail(email);
    }

    @Override
    public UserDTOSummary selectUserSummaryById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(
                        "User with id " + id +" was not found!"
                ));
        UserDetails userDetails = userDetailsRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(
                        "User Details with id " + id + " was not found!"
                ));
        return null;
    }

    @Override
    public void insertUser(User customer) {
        //TODO
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public void deleteUserById(Integer customerId) {
        userRepository.deleteById(customerId);
    }

    @Override
    public void updateUser(User updatedCustomer) {
        userRepository.save(updatedCustomer);
    }
}
