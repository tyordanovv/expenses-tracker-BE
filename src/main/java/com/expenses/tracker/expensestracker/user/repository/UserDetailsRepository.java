package com.expenses.tracker.expensestracker.user.repository;

import com.expenses.tracker.expensestracker.user.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
