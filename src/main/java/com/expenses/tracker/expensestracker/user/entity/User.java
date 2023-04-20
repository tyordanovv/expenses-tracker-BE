package com.expenses.tracker.expensestracker.user.entity;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "user_email_unique",
                        columnNames = "email"
                )
        }
)
public class User { // implements UserDetails

    @Id
    @SequenceGenerator(
            name = "user_id_seq",
            sequenceName = "customer_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq"
    )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private Integer age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String password;
}
