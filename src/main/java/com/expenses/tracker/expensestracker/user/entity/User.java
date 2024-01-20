package com.expenses.tracker.expensestracker.user.entity;

import com.expenses.tracker.expensestracker.account.entity.BankAccount;
import com.expenses.tracker.expensestracker.account.entity.CashAccount;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.STRING
)
@NoArgsConstructor
@Getter
public class User implements Serializable, org.springframework.security.core.userdetails.UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_id_seq",
            sequenceName = "customer_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq")
    @Column(name = "user_id")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "last_login")
    private LocalDate last_login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    @Unique
    private String email;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @OneToMany(mappedBy = "user")
    private Set<CashAccount> cashAccounts;

    @OneToMany(mappedBy = "user")
    private Set<BankAccount> bankAccounts;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private com.expenses.tracker.expensestracker.user.entity.UserDetails userDetails;

    @Column(name = "enabled")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationType registrationType;

    // Getters and Setters
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setEmail(String email){this.email = email;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setLastLogin(LocalDate date){this.last_login = date;}
    public void setRoles(Set<UserRole> roles) {this.roles = roles;}
    public void setCashAccounts(Set<CashAccount> cashAccounts) {this.cashAccounts = cashAccounts;}
    public void setUserDetails(UserDetails userDetails) {this.userDetails = userDetails;}

    public User(
            String firstName,
            String lastName,
            String email,
            String password,
            Set<UserRole> roles,
            RegistrationType registrationType
    ) {
        this.last_login = LocalDate.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.enabled = true;
        this.registrationType = registrationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User customer = (User) o;
        return Objects.equals(id, customer.id)
                && Objects.equals(firstName, customer.firstName)
                && Objects.equals(lastName, customer.lastName)
                && Objects.equals(email, customer.email);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
