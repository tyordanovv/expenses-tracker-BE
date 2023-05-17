package com.expenses.tracker.expensestracker.user.dto;

import com.expenses.tracker.expensestracker.account.entity.Account;
import com.expenses.tracker.expensestracker.user.entity.Gender;
import com.expenses.tracker.expensestracker.user.entity.RegistrationType;
import com.expenses.tracker.expensestracker.user.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record UserDTO(
        Integer id,
        String firstName,
        String lastName,
        String email,
        Set<String> roles,
        Set<UUID> accounts,
        String registrationType
) {}
