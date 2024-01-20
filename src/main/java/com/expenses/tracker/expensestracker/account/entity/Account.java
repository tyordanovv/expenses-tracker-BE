package com.expenses.tracker.expensestracker.account.entity;

import com.expenses.tracker.expensestracker.transaction.entity.Transaction;
import com.expenses.tracker.expensestracker.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@MappedSuperclass
@Getter
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_id_seq",
            sequenceName = "account_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_id_seq")
    @Column(name = "account_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "account_name")
    private String name;
    @OneToMany(mappedBy = "transaction")
    private Set<Transaction> transactions;
}
