package com.expenses.tracker.expensestracker.account.entity;

import com.expenses.tracker.expensestracker.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@MappedSuperclass
@Getter
public class Account {
    @Id
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
