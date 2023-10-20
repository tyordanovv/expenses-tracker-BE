package com.expenses.tracker.expensestracker.user.dao;

import com.expenses.tracker.expensestracker.security.auth.RegistrationRequest;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.dto.UserDTOSummary;
import com.expenses.tracker.expensestracker.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> selectAllUsers();
    Optional<User> selectUserById(Integer customerId);
    Optional<User> selectUserByEmail(String email);
    UserDTOSummary selectUserSummaryById(Integer id);
    UserDTO insertUser(RegistrationRequest customer);
    boolean existsUserWithEmail(String email);
    void deleteUserById(Integer customerId);
    void updateUser(User update);
}
