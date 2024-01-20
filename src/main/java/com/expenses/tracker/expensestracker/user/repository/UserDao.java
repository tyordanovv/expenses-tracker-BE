package com.expenses.tracker.expensestracker.user.repository;

import com.expenses.tracker.expensestracker.user.auth.RegistrationRequest;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.dto.UserDTOSummary;
import com.expenses.tracker.expensestracker.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> selectAllUsers();
    Optional<User> selectUserById(Long customerId);
    Optional<User> selectUserByEmail(String email);
    UserDTOSummary selectUserSummaryById(Long id);
    UserDTO insertUser(RegistrationRequest customer);
    boolean existsUserWithEmail(String email);
    void deleteUserById(Long customerId);
    void updateUser(User update);
}
