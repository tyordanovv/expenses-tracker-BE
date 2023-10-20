package com.expenses.tracker.expensestracker.account.entity;

import com.expenses.tracker.expensestracker.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

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

    public UUID getUuid() {
        return uuid;
    }

    public User getUser() {
        return user;
    }

    public String getAccount_id() {
        return account_id;
    }

    public String getInstitution_id() {
        return institution_id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getCountry() {
        return country;
    }
}
