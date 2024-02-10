package com.expenses.tracker.expensestracker.user.repository;

import com.expenses.tracker.expensestracker.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);
    boolean existsUserById(Integer id);
    Optional<User> findCustomerByEmail(String email);
}
