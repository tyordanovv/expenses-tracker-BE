package com.expenses.tracker.expensestracker.account.entity;

import com.expenses.tracker.expensestracker.user.entity.User;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String account_id;
    private String institution_id;
    private String institutionName;
    private String country;
}
