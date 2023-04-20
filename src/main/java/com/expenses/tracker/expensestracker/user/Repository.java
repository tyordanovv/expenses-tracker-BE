package com.expenses.tracker.expensestracker.user;

import com.expenses.tracker.expensestracker.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Integer> {
}
