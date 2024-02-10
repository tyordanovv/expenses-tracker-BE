package com.expenses.tracker.expensestracker.account.entity;

import com.expenses.tracker.expensestracker.transaction.entity.Transaction;
import com.expenses.tracker.expensestracker.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    protected User user;
    @Column(name = "account_name")
    protected String name;
    @OneToMany(
            mappedBy = "account",
            fetch = FetchType.LAZY
    )
    protected Set<Transaction> transactions;
    @Column(name = "amount")
    private double amount;
    @Column(name = "account_type")
    private AccountType accountType;

    public Account(
        User user,
        String name,
        double amount,
        AccountType accountType
    ){
        this.user = user;
        this.name = name;
        this.amount = amount;
        this.accountType = accountType;
    }
}
